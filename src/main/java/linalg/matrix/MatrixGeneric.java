package linalg.matrix;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import linalg.scalar.Scalar;
import linalg.vector.Vector;
import linalg.vector.VectorGeneric;

/**
 * Generic {@link Matrix}
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixGeneric<T> implements Matrix<T> {

    private final Vector<T>[] rows;

    private final Vector<T>[] columns;

    public MatrixGeneric(final Stream<Scalar<T>>... data) {
        this(Arrays.stream(data).map(VectorGeneric::new));
    }

    @SuppressWarnings("unchecked")
    public MatrixGeneric(final Stream<Vector<T>> data) {
        this(MatrixGeneric.toArray(data));
    }

    @SuppressWarnings("unchecked")
    public MatrixGeneric(final Vector<T>[] rows) {
        this.rows = new Vector[rows.length];
        System.arraycopy(rows, 0, this.rows, 0, rows.length);
        final int cols = rows.length > 0 ? rows[0].dimension() : 0;
        this.columns = new Vector[cols];
        IntStream.range(0, cols).forEach(col ->
            this.columns[col] = new VectorGeneric(
                IntStream.range(0, rows.length)
                    .mapToObj(row -> this.rows[row].at(col))
        ));
    }

    @Override
    public int rows() {
        return this.rows.length;
    }

    @Override
    public int columns() {
        return this.columns.length;
    }

    @Override
    public Stream<Vector<T>> allRows() {
        return Arrays.stream(this.rows);
    }

    @Override
    public Stream<Vector<T>> allColumns() {
        return Arrays.stream(this.columns);
    }

    @Override
    public Scalar<T> at(final int row, final int col) {
        return this.rows[row].at(col);
    }

    @Override
    public Vector<T> row(final int row) {
        return this.rows[row];
    }

    @Override
    public Vector<T> column(final int col) {
        return this.columns[col];
    }

    @Override
    public String toString() {
        return String.format(
            "[%s]",
            this.allRows()
                .map(Vector::toString)
                .collect(Collectors.joining("\n"))
        );
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static <U> Vector<U>[] toArray(final Stream<Vector<U>> data) {
        return data.toArray(Vector[]::new);
    }

}
