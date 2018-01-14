package linalg.matrix.function;

import linalg.function.Function;
import linalg.matrix.Matrix;
import linalg.matrix.computation.MatrixProductComputation;
import lombok.RequiredArgsConstructor;

/**
 * Generic {@link Matrix} right product X -> X * A {@link Function}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixRightProductFunction<T> implements DifferentiableMatrixFunction<T, Matrix<T>> {

    private final Matrix<T> right;

    @Override
    public Matrix<T> at(final Matrix<T> input) {
        return new MatrixProductComputation<>(input, this.right).compute();
    }

    @Override
    public Function<Matrix<T>, Function<Matrix<T>, Matrix<T>>> derivative() {
        return X -> this;
    }

}
