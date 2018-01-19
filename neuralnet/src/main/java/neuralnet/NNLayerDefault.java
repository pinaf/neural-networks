package neuralnet;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import linalg.function.CompositeDifferentiableFunction;
import linalg.function.DifferentiableFunction;
import linalg.function.Function;
import linalg.matrix.Matrix;
import linalg.matrix.MatrixGeneric;
import linalg.matrix.MatrixRandomBigDecimal;
import linalg.matrix.computation.MatrixColumnBroadcast;
import linalg.matrix.computation.MatrixDelta;
import linalg.matrix.computation.MatrixDifferenceComputation;
import linalg.matrix.function.MatrixLeftAffineFunction;
import linalg.matrix.function.MatrixPointwiseDifferentiableFunction;
import linalg.matrix.function.MatrixPointwiseFunction;
import linalg.matrix.function.MatrixRightAffineFunction;
import linalg.scalar.Scalar;
import linalg.vector.Vector;
import linalg.vector.VectorBigDecimal;
import linalg.vector.VectorGeneric;
import linalg.vector.computation.VectorDifferenceComputation;
import linalg.vector.computation.VectorPointwise;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import neuralnet.activation.ActivationFunction;

/**
 * Default implementation of {@link NNLayer}
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@Slf4j
@ToString(of = { "weights", "bias" })
public final class NNLayerDefault implements NNLayer<Matrix<BigDecimal>, Function<Matrix<BigDecimal>, Scalar<BigDecimal>>> {

    private final ActivationFunction<BigDecimal> activation;

    private final Scalar<BigDecimal> rate;

    private Matrix<BigDecimal> weights;

    private Vector<BigDecimal> bias;

    private Matrix<BigDecimal> input;

    private Matrix<BigDecimal> z;

    private Matrix<BigDecimal> a;

    public NNLayerDefault(final ActivationFunction<BigDecimal> activation,
        final int neurons, final int input, final Scalar<BigDecimal> rate) {
        this.activation = activation;
        this.rate = rate;
        this.weights = new MatrixRandomBigDecimal(neurons, input);
        this.bias = new VectorBigDecimal(neurons, BigDecimal.ZERO);
    }

    @Override
    public Matrix<BigDecimal> forward(final Matrix<BigDecimal> signal) {
        this.input = signal;
        this.z = this.linear().at(signal);
        this.a = this.activate().at(this.z);
        return this.a;
    }

    @Override
    public Function<Matrix<BigDecimal>, Scalar<BigDecimal>> backward(final Function<Matrix<BigDecimal>, Scalar<BigDecimal>> signal) {
        final Matrix<BigDecimal> b = this.bias();
        final Function<Matrix<BigDecimal>, Scalar<BigDecimal>> fw = H ->
            signal.at(
                new CompositeDifferentiableFunction<>(
                    new MatrixRightAffineFunction<>(this.input, b),
                    this.activate()
                ).derivative().at(this.weights).at(H)
            );
        final Function<Matrix<BigDecimal>, Scalar<BigDecimal>> fb = H ->
            signal.at(
                this.activate().derivative().at(b).at(H)
            );
        final Matrix<BigDecimal> DW = new MatrixGeneric<>(
            IntStream.range(0, this.weights.rows()).boxed().map(row ->
                new VectorGeneric<>(
                    IntStream.range(0, this.weights.columns()).mapToObj(col ->
                        new MatrixDelta(this.weights.rows(), this.weights.columns(), row, col)
                    ).map(fw::at)
                )
            )
        );
        final Vector<BigDecimal> DB = new MatrixGeneric<>(
            IntStream.range(0, b.rows()).boxed().map(row ->
                new VectorGeneric<>(
                    IntStream.range(0, b.columns()).mapToObj(col ->
                        new MatrixDelta(b.rows(), b.columns(), row, col)
                    ).map(fb::at)
                )
            )
        ).column(0);
        this.weights = new MatrixDifferenceComputation<>(
            this.weights,
            new MatrixPointwiseFunction<>(this.rate::product).at(DW)
        ).compute();
        this.bias = new VectorDifferenceComputation<>(
            this.bias,
            new VectorPointwise<>(DB, this.rate::product).compute()
        ).compute();
        return H -> signal.at(this.full().derivative().at(this.input).at(H));
    }

    private DifferentiableFunction<Matrix<BigDecimal>, Matrix<BigDecimal>> activate() {
        return new MatrixPointwiseDifferentiableFunction<>(this.activation);
    }

    private DifferentiableFunction<Matrix<BigDecimal>, Matrix<BigDecimal>> linear() {
        return new MatrixLeftAffineFunction<>(this.weights, this.bias());
    }

    private DifferentiableFunction<Matrix<BigDecimal>, Matrix<BigDecimal>> full() {
        return new CompositeDifferentiableFunction<>(this.linear(), this.activate());
    }

    private Matrix<BigDecimal> bias() {
        return new MatrixColumnBroadcast<>(this.input.columns(), this.bias).compute();
    }

}
