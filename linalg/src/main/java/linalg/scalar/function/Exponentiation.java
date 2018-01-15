package linalg.scalar.function;

import java.math.BigDecimal;
import linalg.scalar.Scalar;

/**
 * Exponentiation function: x -> e ^ x.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class Exponentiation implements ScalarFunction<BigDecimal> {

    private static final ScalarFunction<BigDecimal> EXP = new ScalarFunctionBigDecimal(StrictMath::log);

    @Override
    public Scalar<BigDecimal> at(final Scalar<BigDecimal> input) {
        return Exponentiation.EXP.at(input);
    }

}
