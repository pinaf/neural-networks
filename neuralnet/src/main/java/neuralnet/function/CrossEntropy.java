package neuralnet.function;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import linalg.function.DifferentiableFunction;
import linalg.function.Function;
import linalg.scalar.Scalar;
import linalg.scalar.ScalarBigDecimal;
import linalg.scalar.function.NaturalLogarithm;
import linalg.scalar.function.ScalarFunction;
import linalg.vector.Vector;
import linalg.vector.VectorGeneric;
import linalg.vector.computation.VectorElementSum;
import lombok.RequiredArgsConstructor;

/**
 * Cross Entropy.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CrossEntropy implements DifferentiableFunction<Vector<BigDecimal>, Scalar<BigDecimal>> {

    private static final ScalarFunction<BigDecimal> LOG = new NaturalLogarithm();

    private final Vector<BigDecimal> reference;

    @Override
    public Scalar<BigDecimal> at(final Vector<BigDecimal> input) {
        return IntStream.range(0, this.reference.dimension()).mapToObj(i ->
            this.reference.at(i).product(CrossEntropy.LOG.at(input.at(i))).sum(
                new ScalarBigDecimal(BigDecimal.ONE).difference(this.reference.at(i))
                    .product(CrossEntropy.LOG.at(new ScalarBigDecimal(BigDecimal.ONE).difference(input.at(i))))
            )
        ).reduce(Scalar::sum).get().negate();
    }

    @Override
    public Function<Vector<BigDecimal>, Function<Vector<BigDecimal>, Scalar<BigDecimal>>> derivative() {
        return A -> H -> new VectorElementSum<>(
            new VectorGeneric<>(
                IntStream.range(0, this.reference.dimension()).mapToObj(i ->
                    this.reference.at(i).quotient(A.at(i)).negate().sum(
                        this.reference.at(i).one().difference(this.reference.at(i))
                            .quotient(A.at(i).one().difference(A.at(i)))
                    )
                )
            )
        ).compute();
    }

}
