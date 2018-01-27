package neuralnet.activation;

import java.math.BigDecimal;
import linalg.function.Function;
import linalg.scalar.Scalar;

/**
 * Identity {@link Function}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class IdentityFunction implements ActivationFunction<BigDecimal> {

    private final Function<Scalar<BigDecimal>, Scalar<BigDecimal>> identity = new linalg.function.IdentityFunction<>();

    @Override
    public Function<Scalar<BigDecimal>, Function<Scalar<BigDecimal>, Scalar<BigDecimal>>> derivative() {
        return X -> this.identity;
    }

    @Override
    public Scalar<BigDecimal> at(final Scalar<BigDecimal> input) {
        return this.identity.at(input);
    }

}
