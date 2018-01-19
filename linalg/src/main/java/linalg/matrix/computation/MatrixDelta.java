package linalg.matrix.computation;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import linalg.matrix.MatrixGeneric;
import linalg.matrix.MatrixWrap;
import linalg.scalar.ScalarBigDecimal;
import linalg.vector.VectorGeneric;

/**
 * Delta Matrix.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixDelta extends MatrixWrap<BigDecimal> {

    public MatrixDelta(final int rows, final int columns, final int row, final int col) {
        super(
            new MatrixGeneric<>(
                IntStream.range(0, rows).mapToObj(i ->
                    new VectorGeneric<>(
                        IntStream.range(0, columns).mapToObj(j -> {
                            if (i == row && j == col) {
                                return new ScalarBigDecimal(BigDecimal.ONE);
                            } else {
                                return new ScalarBigDecimal(BigDecimal.ZERO);
                            }
                        })
                    )
                )
            )
        );
    }

}
