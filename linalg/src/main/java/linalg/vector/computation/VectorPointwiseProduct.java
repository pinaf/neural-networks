package linalg.vector.computation;

import linalg.scalar.Scalar;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * Point-wise {@link Vector} product.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorPointwiseProduct<T> implements VectorComputation<T> {

    private final Vector<T> left;

    private final Vector<T> right;

    @Override
    public Vector<T> compute() {
        return new VectorComputationBinary<>(
            this.left,
            this.right,
            Scalar::product
        ).compute();
    }

}
