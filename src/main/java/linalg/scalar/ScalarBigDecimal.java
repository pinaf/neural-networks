package linalg.scalar;

import java.math.BigDecimal;
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
    public Scalar<BigDecimal> product(final Scalar<BigDecimal> multiplicand) {
        return new ScalarBigDecimal(this.value.multiply(multiplicand.value()));
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
