package linalg.matrix.function;

import linalg.function.Function;
import linalg.matrix.Matrix;
import linalg.matrix.computation.MatrixPointwiseComputation;
import linalg.scalar.Scalar;
import lombok.RequiredArgsConstructor;

/**
 * Point-wise {@link Matrix} function.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixPointwiseFunction<T> implements MatrixFunction<T, Matrix<T>> {

    private final Function<Scalar<T>, Scalar<T>> function;

    @Override
    public Matrix<T> at(final Matrix<T> input) {
        return new MatrixPointwiseComputation<>(input, this.function).compute();
    }

}
