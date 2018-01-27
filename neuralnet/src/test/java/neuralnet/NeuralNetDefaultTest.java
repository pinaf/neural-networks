package neuralnet;

import java.math.BigDecimal;

import org.junit.Test;

import linalg.function.DifferentiableFunction;
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
import neuralnet.optimization.GradientDescent;

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
        final Matrix<BigDecimal> expected = this.expected(input);
        final DifferentiableFunction<Matrix<BigDecimal>, Scalar<BigDecimal>> cost = new AverageCrossEntropyMatrix(expected);
        log.info("Final cost: {}", new GradientDescent<>(net, cost, input, 100).optimize());
        log.info(net.toString());
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
