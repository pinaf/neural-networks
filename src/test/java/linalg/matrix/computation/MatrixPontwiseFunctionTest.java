package linalg.matrix.computation;

import linalg.matrix.MatrixBigDecimal;
import linalg.scalar.ScalarBigDecimal;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link MatrixPontwiseFunction}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class MatrixPontwiseFunctionTest {

    @Test
    public void appliesFunction() {
        MatcherAssert.assertThat(
            new MatrixPontwiseFunction<>(
                new MatrixBigDecimal(
                    2, 3,
                    1, 2, 3,
                    4, -5, 6
                ),
                x -> x.product(new ScalarBigDecimal(2))
            ).compute(),
            Matchers.is(
                new MatrixMatcher(
                    new MatrixBigDecimal(
                        2, 3,
                        2, 4, 6,
                        8, -10, 12
                    )
                )
            )
        );
    }

}
