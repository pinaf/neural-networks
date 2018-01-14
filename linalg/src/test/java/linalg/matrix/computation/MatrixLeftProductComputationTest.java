package linalg.matrix.computation;

import linalg.matrix.MatrixBigDecimal;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link MatrixLeftProductComputation}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixLeftProductComputationTest {

    @Test
    public void matrixProduct() {
        MatcherAssert.assertThat(
            new MatrixLeftProductComputation<>(
                new MatrixBigDecimal(5, 3),
                new MatrixBigDecimal(3, 4)
            ).compute(),
            Matchers.is(new MatrixMatcher(new MatrixBigDecimal(5, 4)))
        );
        MatcherAssert.assertThat(
            new MatrixLeftProductComputation<>(
                new MatrixBigDecimal(
                    2, 3,
                    1, 2, 3,
                    4, 5, 6
                ),
                new MatrixBigDecimal(
                    3, 4,
                    1, 2, -3, -4,
                    4, 5, -3, -2,
                    0, 2, -1, -1
                )
            ).compute(),
            Matchers.is(
                new MatrixMatcher(
                    new MatrixBigDecimal(
                        2, 4,
                        9, 18, -12, -11,
                        24, 45, -33, -32
                    )
                )
            )
        );
    }

}
