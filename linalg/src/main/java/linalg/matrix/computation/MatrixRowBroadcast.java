package linalg.matrix.computation;

import java.util.stream.IntStream;
import linalg.matrix.Matrix;
import linalg.matrix.MatrixGeneric;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * Row-broadcasts a {@link Vector} into a {@link Matrix}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixRowBroadcast<T> implements MatrixComputation<T> {

    private final int size;

    private final Vector<T> vector;

    @Override
    public Matrix<T> compute() {
        return new MatrixGeneric<>(
            IntStream.range(0, this.size).mapToObj(i -> this.vector)
        );
    }

}
