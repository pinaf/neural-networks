package linalg.matrix.computation;

import linalg.matrix.Matrix;
import linalg.vector.computation.VectorDotProduct;
import lombok.RequiredArgsConstructor;

/**
 * Generic {@link Matrix} left product X -> A * X.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixProductComputation<T> implements MatrixComputation<T> {

    private final Matrix<T> left;

    private final Matrix<T> right;

    @Override
    public Matrix<T> compute() {
        return new MatrixGenericProduct<>(
            this.left, this.right,
            (u, v) -> new VectorDotProduct<>(u, v).compute()
        ).compute();
    }

}
