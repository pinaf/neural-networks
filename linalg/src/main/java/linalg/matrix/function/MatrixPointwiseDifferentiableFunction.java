package linalg.matrix.function;

import linalg.function.DifferentiableFunction;
import linalg.function.Function;
import linalg.matrix.Matrix;
import linalg.scalar.Scalar;
import lombok.RequiredArgsConstructor;

/**
 * A {@link Matrix} point-wise {@link DifferentiableFunction}: A -> f(A).
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixPointwiseDifferentiableFunction<T> implements DifferentiableMatrixFunction<T, Matrix<T>> {

    private final DifferentiableFunction<Scalar<T>, Scalar<T>> function;

    @Override
    public Matrix<T> at(final Matrix<T> input) {
        return new MatrixPointwiseFunction<>(this.function).at(input);
    }

    @Override
    public Function<Matrix<T>, Function<Matrix<T>, Matrix<T>>> derivative() {
        final Function<Scalar<T>, Scalar<T>> diff = x -> this.function.derivative().at(x).at(x.one());
        return A -> new MatrixPointwiseProductFunction<>(
            new MatrixPointwiseFunction<>(diff).at(A)
        );
    }

}
