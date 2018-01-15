package linalg.vector.computation;

import linalg.scalar.Scalar;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * Computes a {@link Vector} difference: v - w.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorDifference<T> implements VectorComputation<T> {

    private final Vector<T> left;

    private final Vector<T> right;

    @Override
    public Vector<T> compute() {
        return new VectorComputationBinary<>(this.left, this.right, Scalar::difference)
            .compute();
    }

}
