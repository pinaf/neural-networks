package linalg.vector;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A Randomized {@link Vector} of {@link BigDecimal}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class VectorRandomBigDecimal extends VectorWrap<BigDecimal> {

    public VectorRandomBigDecimal(final int dimension) {
        super(new VectorBigDecimal(VectorRandomBigDecimal.randomize(dimension)));
    }

    private static Stream<BigDecimal> randomize(final int dimension) {
        final Random random = new Random();
        return IntStream.range(0, dimension).mapToObj(i -> BigDecimal.valueOf(random.nextDouble()));
    }

}
