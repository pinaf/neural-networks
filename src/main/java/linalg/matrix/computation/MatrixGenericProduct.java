package linalg.matrix.computation;

import java.util.function.BiFunction;
import java.util.stream.IntStream;
import linalg.matrix.Matrix;
import linalg.matrix.MatrixGeneric;
import linalg.scalar.Scalar;
import linalg.vector.Vector;
import linalg.vector.VectorGeneric;
import lombok.RequiredArgsConstructor;

/**
 * Product of two instances of {@link Matrix}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixGenericProduct<T> implements MatrixComputation<T> {

    private final Matrix<T> left;

    private final Matrix<T> right;

    private final BiFunction<Vector<T>, Vector<T>, Scalar<T>> function;

    @Override
    public Matrix<T> compute() {
        return new MatrixGeneric<>(
            IntStream.range(0, this.left.rows()).mapToObj(row ->
                new VectorGeneric<>(
                    IntStream.range(0, this.right.columns()).mapToObj(col ->
                        this.function.apply(
                            this.left.row(row),
                            this.right.column(col)
                        )
                    )
                )
            )
        );
    }

}
