package linalg.vector;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import linalg.scalar.ScalarBigDecimal;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * A {@link BigDecimal} {@link Vector}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public final class VectorBigDecimal extends VectorWrap<BigDecimal> {

    public VectorBigDecimal(final int dimension) {
        this(IntStream.range(0, dimension).mapToObj(i -> BigDecimal.ZERO));
    }

    public VectorBigDecimal(final Stream<BigDecimal> data) {
        super(new VectorGeneric<>(data.map(ScalarBigDecimal::new)));
    }

    public VectorBigDecimal(final Number... data) {
        this(
            Arrays.stream(data)
                .mapToDouble(Number::doubleValue)
                .mapToObj(BigDecimal::valueOf)
        );
    }

}
