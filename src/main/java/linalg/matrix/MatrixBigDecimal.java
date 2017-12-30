package linalg.matrix;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
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
        super(
            new MatrixGeneric<>(
                IntStream.range(0, rows)
                    .mapToObj(row -> new VectorBigDecimal(columns))
            )
        );
    }

    public MatrixBigDecimal(final int rows, final int columns, final Number... data) {
        super(
            new MatrixGeneric<>(
                MatrixBigDecimal.split(rows, columns, data)
            )
        );
    }

    private static Stream<Vector<BigDecimal>> split(final int rows,
        final int columns, final Number... data) {
        if (rows * columns != data.length) {
            throw new IllegalArgumentException("Invalid matrix input data");
        }
        final Collection<Vector<BigDecimal>> all = new ArrayList<>(data.length / 4);
        final Number[] current = new Number[columns];
        int pos = 0;
        for (int idx = 0; idx < rows; ++idx) {
            for (int jdx = 0; jdx < columns; ++jdx) {
                current[jdx] = data[pos];
                pos++;
            }
            all.add(new VectorBigDecimal(current));
        }
        return all.stream();
    }

}
