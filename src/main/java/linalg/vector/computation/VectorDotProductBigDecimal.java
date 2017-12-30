package linalg.vector.computation;

import java.math.BigDecimal;
import linalg.scalar.computation.ScalarComputation;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * A {@link Vector} dot product.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorDotProductBigDecimal implements ScalarComputation<BigDecimal> {

    private final Vector<BigDecimal> left;

    private final Vector<BigDecimal> right;

    @Override
    public BigDecimal compute() {
        return new VectorScalarComputationBinary<>(
            this.left, this.right,
            BigDecimal::multiply,
            BigDecimal::add
        ).compute();
    }

}
