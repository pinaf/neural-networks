package linalg.matrix.computation;

import java.util.function.Function;
import linalg.matrix.Matrix;
import linalg.matrix.MatrixGeneric;
import linalg.scalar.Scalar;
import linalg.vector.computation.VectorPointwiseFuncion;
import lombok.RequiredArgsConstructor;

/**
 * Point-wise {@link Matrix} function.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixPontwiseFunction<T> implements MatrixComputation<T> {

    private final Matrix<T> matrix;

    private final Function<Scalar<T>, Scalar<T>> function;

    @Override
    public Matrix<T> compute() {
        return new MatrixGeneric<>(
            this.matrix.allRows()
                .map(v -> new VectorPointwiseFuncion<>(v, this.function).compute())
        );
    }

}
