package neuralnet.activation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import linalg.scalar.Scalar;
import linalg.scalar.ScalarBigDecimal;

/**
 * Sigmoid {@link ActivationFunction}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class Sigmoid implements ActivationFunction<BigDecimal> {

    @Override
    public Scalar<BigDecimal> apply(final Scalar<BigDecimal> scalar) {
        return new ScalarBigDecimal(Sigmoid.sigmoid(scalar.value()));
    }

    @Override
    public ScalarFunction<BigDecimal> derivative() {
        return x -> new ScalarBigDecimal(Sigmoid.derivative(x.value()));
    }

    private static BigDecimal sigmoid(final BigDecimal value) {
        return BigDecimal.ONE.divide(
            BigDecimal.ONE.add(BigDecimal.valueOf(StrictMath.exp(value.negate().doubleValue()))),
            RoundingMode.HALF_DOWN
        );
    }

    private static BigDecimal derivative(final BigDecimal value) {
        final BigDecimal sigmoid = Sigmoid.sigmoid(value);
        return sigmoid.multiply(Sigmoid.sigmoid(BigDecimal.ONE.subtract(sigmoid)));
    }

}
