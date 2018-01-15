package neuralnet.activation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import linalg.function.Function;
import linalg.scalar.Scalar;
import linalg.scalar.ScalarBigDecimal;

/**
 * Sigmoid {@link ActivationFunction}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class Sigmoid implements ActivationFunction<BigDecimal> {

    private static final int SCALE = 10;

    @Override
    public Scalar<BigDecimal> at(final Scalar<BigDecimal> scalar) {
        return new ScalarBigDecimal(Sigmoid.sigmoid(scalar.value()));
    }

    @Override
    public Function<Scalar<BigDecimal>, Function<Scalar<BigDecimal>, Scalar<BigDecimal>>> derivative() {
        return x -> h -> new ScalarBigDecimal(Sigmoid.derivative(x.value())).product(h);
    }

    private static BigDecimal sigmoid(final BigDecimal value) {
        return BigDecimal.ONE.divide(
            BigDecimal.ONE.add(BigDecimal.valueOf(StrictMath.exp(value.negate().doubleValue()))),
            Sigmoid.SCALE,
            RoundingMode.HALF_DOWN
        );
    }

    private static BigDecimal derivative(final BigDecimal value) {
        final BigDecimal sigmoid = Sigmoid.sigmoid(value);
        return sigmoid.multiply(Sigmoid.sigmoid(BigDecimal.ONE.subtract(sigmoid)));
    }

}
