package linalg.vector.computation;

import java.util.function.BinaryOperator;
import linalg.scalar.Scalar;
import linalg.scalar.computation.ScalarComputation;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * A generic, point-wise, accumulating {@link ScalarComputation} on a single {@link Vector}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorScalarComputationUnary<T> implements ScalarComputation<T> {

    private final Vector<T> vector;

    private final BinaryOperator<Scalar<T>> accumulator;

    @Override
    public Scalar<T> compute() {
        return this.vector.stream().reduce(this.accumulator).get();
    }

}
