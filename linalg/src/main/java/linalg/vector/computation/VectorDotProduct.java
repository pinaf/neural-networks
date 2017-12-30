package linalg.vector.computation;

import linalg.scalar.Scalar;
import linalg.scalar.computation.ScalarComputation;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * A {@link Vector} dot product.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorDotProduct<T> implements ScalarComputation<T> {

    private final Vector<T> left;

    private final Vector<T> right;

    @Override
    public Scalar<T> compute() {
        return new VectorScalarComputationBinary<>(
            this.left, this.right,
            Scalar::product,
            Scalar::sum
        ).compute();
    }

}
