package linalg.matrix;

import java.util.stream.Stream;
import linalg.scalar.Scalar;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * Wrap for {@link Matrix}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class MatrixWrap<T> implements Matrix<T> {

    private final Matrix<T> matrix;

    @Override
    public final int rows() {
        return this.matrix.rows();
    }

    @Override
    public final int columns() {
        return this.matrix.columns();
    }

    @Override
    public final Stream<Vector<T>> allRows() {
        return this.matrix.allRows();
    }

    @Override
    public final Stream<Vector<T>> allColumns() {
        return this.matrix.allColumns();
    }

    @Override
    public final Scalar<T> at(final int row, final int col) {
        return this.matrix.at(row, col);
    }

    @Override
    public final Vector<T> row(final int row) {
        return this.matrix.row(row);
    }

    @Override
    public final Vector<T> column(final int col) {
        return this.matrix.column(col);
    }

    public final String toString() {
        return this.matrix.toString();
    }

}
