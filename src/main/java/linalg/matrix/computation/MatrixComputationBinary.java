package linalg.matrix.computation;

import java.util.function.BiFunction;
import java.util.stream.IntStream;
import linalg.matrix.Matrix;
import linalg.matrix.MatrixGeneric;
import linalg.scalar.Scalar;
import linalg.vector.computation.VectorComputationBinary;
import lombok.RequiredArgsConstructor;

/**
 * Generic binary {@link MatrixComputation}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixComputationBinary<T> implements MatrixComputation<T> {

    private final Matrix<T> left;

    private final Matrix<T> right;

    private final BiFunction<Scalar<T>, Scalar<T>, Scalar<T>> function;

    @Override
    public Matrix<T> compute() {
        return new MatrixGeneric<>(
            IntStream.range(0, this.left.rows()).mapToObj(i ->
                new VectorComputationBinary<>(
                    this.left.row(i),
                    this.right.row(i),
                    this.function
                ).compute()
            )
        );
    }

}
