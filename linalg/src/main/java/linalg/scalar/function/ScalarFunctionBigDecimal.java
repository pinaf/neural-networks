package linalg.scalar.function;

import java.math.BigDecimal;
import linalg.function.Function;
import linalg.scalar.Scalar;
import linalg.scalar.ScalarBigDecimal;
import lombok.RequiredArgsConstructor;

/**
 * A generic {@link BigDecimal} {@link ScalarFunction} that wraps a function of
 * {@link Double} to {@link Double}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class ScalarFunctionBigDecimal implements ScalarFunction<BigDecimal> {

    private final Function<Double, Double> function;

    @Override
    public Scalar<BigDecimal> at(final Scalar<BigDecimal> input) {
        return new ScalarBigDecimal(this.function.at(input.value().doubleValue()));
    }

}
