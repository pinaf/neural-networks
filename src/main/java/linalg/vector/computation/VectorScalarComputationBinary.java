package linalg.vector.computation;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import linalg.scalar.Scalar;
import linalg.scalar.computation.ScalarComputation;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * A generic, point-wise, accumulating {@link ScalarComputation} on two {@link Vector}s.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorScalarComputationBinary<T> implements ScalarComputation<T> {

    private final Vector<T> left;

    private final Vector<T> right;

    private final BiFunction<Scalar<T>, Scalar<T>, Scalar<T>> function;

    private final BinaryOperator<Scalar<T>> accumulator;

    @Override
    public Scalar<T> compute() {
        return new VectorComputationBinary<>(this.left, this.right, this.function)
            .compute()
            .stream()
            .reduce(this.accumulator).get();
    }

}
