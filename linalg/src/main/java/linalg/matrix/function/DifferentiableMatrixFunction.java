package linalg.matrix.function;

import linalg.function.DifferentiableFunction;
import linalg.matrix.Matrix;

/**
 * A differentiable {@link MatrixFunction}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface DifferentiableMatrixFunction<S, T> extends MatrixFunction<S, T>, DifferentiableFunction<Matrix<S>, T> {
}
