package linalg.matrix.function;

import linalg.function.CompositeDifferentiableFunction;
import linalg.function.DifferentiableFunction;
import linalg.function.Function;
import linalg.matrix.Matrix;

/**
 * Computes the (right) affine {@link Function} X -> XA + B
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixRightAffineFunction<T> implements DifferentiableMatrixFunction<T, Matrix<T>> {

    private final DifferentiableFunction<Matrix<T>,  Matrix<T>> function;

    public MatrixRightAffineFunction(final Matrix<T> A, final Matrix<T> B) {
        this.function = new CompositeDifferentiableFunction<>(
            new MatrixRightProductFunction<>(A),
            new MatrixSumFunction<>(B)
        );
    }

    @Override
    public Matrix<T> at(final Matrix<T> input) {
        return this.function.at(input);
    }

    @Override
    public Function<Matrix<T>, Function<Matrix<T>, Matrix<T>>> derivative() {
        return this.function.derivative();
    }

}
