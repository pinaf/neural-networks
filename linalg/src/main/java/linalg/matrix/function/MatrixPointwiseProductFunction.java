package linalg.matrix.function;

import linalg.matrix.Matrix;
import linalg.matrix.computation.MatrixPointwiseProduct;
import lombok.RequiredArgsConstructor;

/**
 * Point-wise {@link Matrix} product.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixPointwiseProductFunction<T> implements MatrixFunction<T, Matrix<T>> {

    private final Matrix<T> A;

    @Override
    public Matrix<T> at(final Matrix<T> input) {
        return new MatrixPointwiseProduct<>(this.A, input).compute();
    }

}
