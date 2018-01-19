package neuralnet.activation;

import java.math.BigDecimal;
import linalg.function.Function;
import linalg.scalar.Scalar;
import linalg.scalar.ScalarBigDecimal;

/**
 * ReLu (Rectifier) {@link ActivationFunction}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class ReLuFunction implements ActivationFunction<BigDecimal> {

    @Override
    public Scalar<BigDecimal> at(final Scalar<BigDecimal> input) {
        if (input.value().signum() >= 0) {
            return input;
        } else {
            return new ScalarBigDecimal(BigDecimal.ZERO);
        }
    }

    @Override
    public Function<Scalar<BigDecimal>, Function<Scalar<BigDecimal>, Scalar<BigDecimal>>> derivative() {
        return X -> H -> {
            if (X.value().signum() >= 0) {
                return H;
            } else {
                return new ScalarBigDecimal(BigDecimal.ZERO);
            }
        };
    }

}
