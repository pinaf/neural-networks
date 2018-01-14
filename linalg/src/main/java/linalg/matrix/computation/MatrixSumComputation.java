package linalg.matrix.computation;

import linalg.matrix.Matrix;
import linalg.scalar.Scalar;
import lombok.RequiredArgsConstructor;

/**
 * * Matrix sum: X -> X + A.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixSumComputation<T> implements MatrixComputation<T> {

    private final Matrix<T> left;

    private final Matrix<T> right;

    @Override
    public Matrix<T> compute() {
        return new MatrixComputationBinary<>(this.left, this.right, Scalar::sum)
            .compute();
    }
}
