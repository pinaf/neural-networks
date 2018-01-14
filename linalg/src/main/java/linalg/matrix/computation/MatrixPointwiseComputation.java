package linalg.matrix.computation;

import linalg.function.Function;
import linalg.matrix.Matrix;
import linalg.matrix.MatrixGeneric;
import linalg.scalar.Scalar;
import linalg.vector.computation.VectorPointwiseFuncion;
import lombok.RequiredArgsConstructor;

/**
 * Point-wise {@link Matrix} computation.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixPointwiseComputation<T> implements MatrixComputation<T> {

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
