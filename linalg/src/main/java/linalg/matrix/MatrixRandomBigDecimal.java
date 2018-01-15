package linalg.matrix;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import linalg.vector.VectorRandomBigDecimal;

/**
 * A Randomized {@link Matrix} of {@link BigDecimal}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixRandomBigDecimal extends MatrixWrap<BigDecimal> {

    public MatrixRandomBigDecimal(final int rows, final int columns) {
        super(
            new MatrixGeneric<>(
                IntStream.range(0, rows)
                    .mapToObj(row -> new VectorRandomBigDecimal(columns))
            )
        );
    }

}
