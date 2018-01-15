package linalg.scalar.function;

import java.math.BigDecimal;
import linalg.scalar.Scalar;

/**
 * The natural logarithm function: x -> ln(x).
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class NaturalLogarithm implements ScalarFunction<BigDecimal> {

    private static final ScalarFunction<BigDecimal> LOG = new ScalarFunctionBigDecimal(StrictMath::log);

    @Override
    public Scalar<BigDecimal> at(final Scalar<BigDecimal> input) {
        return NaturalLogarithm.LOG.at(input);
    }

}
