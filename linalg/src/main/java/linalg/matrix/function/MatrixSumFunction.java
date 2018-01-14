package linalg.matrix.function;

import linalg.function.Function;
import linalg.function.IdentityFunction;
import linalg.matrix.Matrix;
import linalg.matrix.computation.MatrixSumComputation;
import lombok.RequiredArgsConstructor;

/**
 * Matrix sum: X -> X + A {@link Function}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixSumFunction<T> implements DifferentiableMatrixFunction<T, Matrix<T>> {

    private final Matrix<T> addend;

    @Override
    public Matrix<T> at(final Matrix<T> input) {
        return new MatrixSumComputation<>(input, this.addend).compute();
    }

    @Override
    public Function<Matrix<T>, Function<Matrix<T>, Matrix<T>>> derivative() {
        return X -> new IdentityFunction<>();
    }

}
