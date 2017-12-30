package linalg.matrix.computation;

import java.math.BigDecimal;
import linalg.matrix.Matrix;
import linalg.matrix.MatrixEquality;
import lombok.RequiredArgsConstructor;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * New class.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
final class MatrixMatcher extends BaseMatcher<Matrix<BigDecimal>> {

    private final Matrix<BigDecimal> matrix;

    @Override
    public boolean matches(final Object obj) {
        final Matrix<BigDecimal> other = Matrix.class.cast(obj);
        return new MatrixEquality<>(this.matrix).test(other);
    }

    @Override
    public void describeTo(final Description description) {
        // empty
    }
}
