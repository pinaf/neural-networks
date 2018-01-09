package linalg.matrix.computation;

import linalg.matrix.Matrix;
import linalg.scalar.Scalar;
import lombok.RequiredArgsConstructor;

/**
 * Point-wise {@link Matrix} product.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixPointwiseProduct<T> implements MatrixComputation<T> {

    private final Matrix<T> left;

    private final Matrix<T> right;

    @Override
    public Matrix<T> compute() {
        return new MatrixComputationBinary<>(
            this.left,
            this.right,
            Scalar::product
        ).compute();
    }

}
