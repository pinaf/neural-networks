package linalg.vector.computation;

import linalg.vector.VectorBigDecimal;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link VectorSum}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class VectorSumTest {

    @Test
    public void addsTwoVectors() {
        MatcherAssert.assertThat(
            new VectorSum<>(
                new VectorBigDecimal(0, 1, 2),
                new VectorBigDecimal(-4, 3, 5)
            ).compute(),
            Matchers.is(new VectorBigDecimal(-4, 4, 7))
        );
    }

}
