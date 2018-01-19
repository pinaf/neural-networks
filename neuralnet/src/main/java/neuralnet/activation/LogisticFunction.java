package neuralnet.activation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import linalg.function.Function;
import linalg.scalar.Scalar;
import linalg.scalar.ScalarBigDecimal;

/**
 * Logistic {@link ActivationFunction}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class LogisticFunction implements ActivationFunction<BigDecimal> {

    private static final int SCALE = 10;

    @Override
    public Scalar<BigDecimal> at(final Scalar<BigDecimal> scalar) {
        return new ScalarBigDecimal(LogisticFunction.sigmoid(scalar.value()));
    }

    @Override
    public Function<Scalar<BigDecimal>, Function<Scalar<BigDecimal>, Scalar<BigDecimal>>> derivative() {
        return x -> h -> new ScalarBigDecimal(LogisticFunction.derivative(x.value())).product(h);
    }

    private static BigDecimal sigmoid(final BigDecimal value) {
        return BigDecimal.ONE.divide(
            BigDecimal.ONE.add(BigDecimal.valueOf(StrictMath.exp(value.negate().doubleValue()))),
            LogisticFunction.SCALE,
            RoundingMode.HALF_DOWN
        );
    }

    private static BigDecimal derivative(final BigDecimal value) {
        final BigDecimal sigmoid = LogisticFunction.sigmoid(value);
        return sigmoid.multiply(LogisticFunction.sigmoid(BigDecimal.ONE.subtract(sigmoid)));
    }

}
