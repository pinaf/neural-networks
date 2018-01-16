package linalg.scalar;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A {@link BigDecimal} typed {@link Scalar}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@Accessors(fluent = true)
@RequiredArgsConstructor
public final class ScalarBigDecimal implements Scalar<BigDecimal> {

    private static final int SCALE = 10;

    @Getter
    private final BigDecimal value;

    public ScalarBigDecimal(final Number value) {
        this(BigDecimal.valueOf(value.doubleValue()));
    }

    @Override
    public Scalar<BigDecimal> sum(final Scalar<BigDecimal> addend) {
        return new ScalarBigDecimal(this.value.add(addend.value()));
    }

    @Override
    public Scalar<BigDecimal> difference(final Scalar<BigDecimal> subtrahend) {
        return new ScalarBigDecimal(this.value.subtract(subtrahend.value()));
    }

    @Override
    public Scalar<BigDecimal> product(final Scalar<BigDecimal> multiplicand) {
        return new ScalarBigDecimal(this.value.multiply(multiplicand.value()));
    }

    @Override
    public Scalar<BigDecimal> quotient(final Scalar<BigDecimal> divisor) {
        return new ScalarBigDecimal(this.value.divide(divisor.value(), ScalarBigDecimal.SCALE, RoundingMode.HALF_DOWN));
    }

    @Override
    public Scalar<BigDecimal> zero() {
        return new ScalarBigDecimal(BigDecimal.ZERO);
    }

    @Override
    public Scalar<BigDecimal> one() {
        return new ScalarBigDecimal(BigDecimal.ONE);
    }

    @Override
    public Scalar<BigDecimal> negate() {
        return new ScalarBigDecimal(this.value.negate());
    }

    @Override
    public boolean isEqualTo(final Scalar<BigDecimal> other) {
        return this.value.compareTo(other.value()) == 0;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
