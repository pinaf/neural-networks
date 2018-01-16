package linalg.matrix.function;

import linalg.function.Function;
import linalg.matrix.Matrix;
import linalg.matrix.computation.MatrixDifferenceComputation;
import linalg.scalar.Scalar;
import lombok.RequiredArgsConstructor;

/**
 * Matrix difference: X -> A - X {@link Function}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixDifferenceFunction<T> implements DifferentiableMatrixFunction<T, Matrix<T>> {

    private final Matrix<T> minuend;

    @Override
    public Matrix<T> at(final Matrix<T> input) {
        return new MatrixDifferenceComputation<>(this.minuend, input).compute();
    }

    @Override
    public Function<Matrix<T>, Function<Matrix<T>, Matrix<T>>> derivative() {
        return X -> new MatrixPointwiseFunction<>(Scalar::negate);
    }

}
