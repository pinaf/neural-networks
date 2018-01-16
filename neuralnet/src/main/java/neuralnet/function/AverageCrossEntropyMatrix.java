package neuralnet.function;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import linalg.function.DifferentiableFunction;
import linalg.function.Function;
import linalg.matrix.Matrix;
import linalg.scalar.Scalar;
import linalg.scalar.ScalarBigDecimal;
import lombok.RequiredArgsConstructor;

/**
 * Average Cross Entropy for {@link Matrix}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class AverageCrossEntropyMatrix implements DifferentiableFunction<Matrix<BigDecimal>, Scalar<BigDecimal>> {

    private final Matrix<BigDecimal> reference;

    @Override
    public Scalar<BigDecimal> at(final Matrix<BigDecimal> input) {
        return IntStream.range(0, this.reference.rows())
            .mapToObj(i -> new CrossEntropy(this.reference.row(i)).at(input.row(i)))
            .reduce(Scalar::sum)
            .get()
            .quotient(new ScalarBigDecimal(this.reference.rows() * this.reference.columns()));
    }

    @Override
    public Function<Matrix<BigDecimal>, Function<Matrix<BigDecimal>, Scalar<BigDecimal>>> derivative() {
        return A -> H -> IntStream.range(0, this.reference.rows())
            .mapToObj(i -> new CrossEntropy(this.reference.row(i)).derivative().at(A.row(i)).at(H.row(i)))
            .reduce(Scalar::sum)
            .get()
            .quotient(new ScalarBigDecimal(this.reference.rows() * this.reference.columns()));
    }

}
