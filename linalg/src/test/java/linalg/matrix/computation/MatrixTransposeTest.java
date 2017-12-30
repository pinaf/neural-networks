package linalg.matrix.computation;

import linalg.matrix.MatrixBigDecimal;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link MatrixTranspose};
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixTransposeTest {

    @Test
    public void transposesMatrix() {
        MatcherAssert.assertThat(
            new MatrixTranspose<>(
                new MatrixBigDecimal(
                    2, 3,
                    1, 2, 3,
                    4, -5, 6
                )
            ).compute(),
            Matchers.is(
                new MatrixMatcher(
                    new MatrixBigDecimal(
                        3, 2,
                        1, 4,
                        2, -5,
                        3, 6
                    )
                )
            )
        );
    }

}
