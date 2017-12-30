package linalg.matrix.computation;

import linalg.matrix.Matrix;
import linalg.matrix.MatrixGeneric;
import lombok.RequiredArgsConstructor;

/**
 * Matrix transposition.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixTranspose<T> implements MatrixComputation<T> {

    private final Matrix<T> matrix;

    @Override
    public Matrix<T> compute() {
        return new MatrixGeneric<>(this.matrix.allColumns());
    }

}
