package linalg.vector.computation;

import java.math.BigDecimal;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * Vector addition for {@link BigDecimal} {@link Vector}s.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorAddBigDecimal implements VectorComputation<BigDecimal> {

    private final Vector<BigDecimal> left;

    private final Vector<BigDecimal> right;

    @Override
    public Vector<BigDecimal> compute() {
        return new VectorComputationBinary<>(
            this.left, this.right, BigDecimal::add
        ).compute();
    }

}
