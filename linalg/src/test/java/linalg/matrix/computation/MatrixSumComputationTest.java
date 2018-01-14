package linalg.matrix.computation;

import linalg.matrix.MatrixBigDecimal;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link MatrixSumComputation}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixSumComputationTest {

    @Test
    public void computesSum() {
        MatcherAssert.assertThat(
            new MatrixSumComputation<>(
                new MatrixBigDecimal(
                    2, 3,
                    1, 2, 3,
                    4, 5, 6
                ),
                new MatrixBigDecimal(
                    2, 3,
                    2, -3, -4,
                    5, -3, -2
                )
            ).compute(),
            Matchers.is(
                new MatrixMatcher(
                    new MatrixBigDecimal(
                        2, 3,
                        3, -1, -1,
                        9, 2, 4
                    )
                )
            )
        );
    }

}
