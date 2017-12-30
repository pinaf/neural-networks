package linalg.matrix;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import linalg.vector.VectorEquality;
import lombok.RequiredArgsConstructor;

/**
 * Matrix Equality.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixEquality<T> implements Predicate<Matrix<T>> {

    private final Matrix<T> matrix;

    @Override
    public boolean test(final Matrix<T> other) {
        return this.matrix.rows() == other.rows() &&
            this.matrix.columns() == other.columns() &&
            IntStream.range(0, this.matrix.rows())
                .allMatch(i -> new VectorEquality<>(this.matrix.row(i)).test(other.row(i)));
    }

}
