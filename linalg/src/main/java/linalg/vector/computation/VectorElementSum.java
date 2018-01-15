package linalg.vector.computation;

import linalg.scalar.Scalar;
import linalg.scalar.computation.ScalarComputation;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * Sum of {@link Vector} elements.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorElementSum<T> implements ScalarComputation<T> {

    private final Vector<T> vector;

    @Override
    public Scalar<T> compute() {
        return new VectorScalarComputationUnary<>(this.vector, Scalar::sum).compute();
    }

}
