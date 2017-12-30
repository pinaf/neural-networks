package linalg.matrix.computation;

import java.math.BigDecimal;
import linalg.matrix.Matrix;
import linalg.vector.computation.VectorDotProductBigDecimal;
import lombok.RequiredArgsConstructor;

/**
 * Matrix product for {@link BigDecimal} {@link Matrix}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class MatrixProductBigDecimal implements MatrixComputation<BigDecimal> {

    private final Matrix<BigDecimal> left;

    private final Matrix<BigDecimal> right;

    @Override
    public Matrix<BigDecimal> compute() {
        return new MatrixGenericProductBinary<>(
            this.left, this.right,
            (u, v) -> new VectorDotProductBigDecimal(u, v).compute()
        ).compute();
    }

}
