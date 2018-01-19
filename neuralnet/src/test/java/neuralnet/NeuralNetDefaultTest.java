package neuralnet;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import org.junit.Test;

import linalg.function.Function;
import linalg.matrix.Matrix;
import linalg.matrix.MatrixGeneric;
import linalg.matrix.MatrixRandomBigDecimal;
import linalg.matrix.computation.MatrixTranspose;
import linalg.scalar.Scalar;
import linalg.scalar.ScalarBigDecimal;
import linalg.vector.VectorBigDecimal;
import lombok.extern.slf4j.Slf4j;
import neuralnet.activation.LogisticFunction;
import neuralnet.function.AverageCrossEntropyMatrix;

/**
 * Tests for {@link NeuralNetDefault}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@Slf4j
public final class NeuralNetDefaultTest {

    @Test
    public void lineSeparation() {
        final Scalar<BigDecimal> rate = new ScalarBigDecimal(new BigDecimal("50"));
        final NeuralNet<Matrix<BigDecimal>, Function<Matrix<BigDecimal>, Scalar<BigDecimal>>> net = new NeuralNetDefault<>(
            //new NNLayerDefault(new ReLuFunction(), 5, 2, rate),
            new NNLayerDefault(new LogisticFunction(), 1, 2, rate)
        );
        final Matrix<BigDecimal> input = new MatrixRandomBigDecimal(2, 1000);
        IntStream.range(0, 100)
            .forEach(i -> {
                log.info("Iteration: {}", i);
                this.cycle(net, input);
            });
        log.info(net.toString());
    }

    private Scalar<BigDecimal> cycle(final NeuralNet<Matrix<BigDecimal>, Function<Matrix<BigDecimal>, Scalar<BigDecimal>>> net, final Matrix<BigDecimal> input) {
        final Matrix<BigDecimal> expected = this.expected(input);
        //log.info("Input: {}", input);
        //log.info("Expected: {}", expected);
        final Matrix<BigDecimal> output = net.forward(input);
        //log.info("Output: {}", output);
        final Scalar<BigDecimal> cost = this.cost(output, expected);
        log.info("Cost: {}", cost);
        //log.info("DCost: {}", this.costDerivative(output, expected).at(new MatrixBigDecimal(output.rows(), output.columns(), BigDecimal.ONE)));
        net.backward(this.costDerivative(output, expected));
        return cost;
    }

    private Scalar<BigDecimal> cost(final Matrix<BigDecimal> output, final Matrix<BigDecimal> expected) {
        return new AverageCrossEntropyMatrix(expected).at(output);
    }

    private Function<Matrix<BigDecimal>, Scalar<BigDecimal>> costDerivative(final Matrix<BigDecimal> output, final Matrix<BigDecimal> expected) {
        return new AverageCrossEntropyMatrix(expected).derivative().at(output);
    }

    private Matrix<BigDecimal> expected(final Matrix<BigDecimal> input) {
        return new MatrixTranspose<>(
            new MatrixGeneric<>(
                input.allColumns()
                    .map(col -> col.at(1).difference(col.at(0)).value().signum() > 0 ? 1 : 0)
                    .map(v -> new VectorBigDecimal(1, BigDecimal.valueOf(v)))
            )
        ).compute();
    }

}
