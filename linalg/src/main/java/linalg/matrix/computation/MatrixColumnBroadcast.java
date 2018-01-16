package linalg.matrix.computation;

import linalg.matrix.Matrix;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * Column-broadcasts a {@link Vector} into a {@link Matrix}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixColumnBroadcast<T> implements MatrixComputation<T> {

    private final int size;

    private final Vector<T> vector;

    @Override
    public Matrix<T> compute() {
        return new MatrixTranspose<>(
            new MatrixRowBroadcast<>(this.size, this.vector).compute()
        ).compute();
    }

}
