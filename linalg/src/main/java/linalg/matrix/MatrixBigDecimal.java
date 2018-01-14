package linalg.matrix;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import linalg.vector.Vector;
import linalg.vector.VectorBigDecimal;

/**
 * A {@link BigDecimal} {@link Matrix}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixBigDecimal extends MatrixWrap<BigDecimal> {

    public MatrixBigDecimal(final int rows, final int columns) {
        this(rows, columns, BigDecimal.ZERO);
    }

    public MatrixBigDecimal(final int rows, final int columns, final BigDecimal value) {
        super(
            new MatrixGeneric<>(
                IntStream.range(0, rows)
                    .mapToObj(row -> new VectorBigDecimal(columns, value))
            )
        );
    }

    public MatrixBigDecimal(final int rows, final int columns, final Number... data) {
        super(
            new MatrixGeneric<>(MatrixBigDecimal.split(rows, columns, data))
        );
    }

    private static Stream<Vector<BigDecimal>> split(final int rows,
        final int columns, final Number... data) {
        if (rows * columns != data.length) {
            throw new IllegalArgumentException("Invalid matrix input data");
        }
        return IntStream.range(0, rows).mapToObj(idx ->
            new VectorBigDecimal(
                IntStream.range(0, columns)
                    .mapToObj(col -> data[idx * columns + col])
                    .toArray(Number[]::new)
            )
        );
    }

}
