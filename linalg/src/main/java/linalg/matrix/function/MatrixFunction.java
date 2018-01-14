package linalg.matrix.function;

import linalg.function.Function;
import linalg.matrix.Matrix;

/**
 * A {@link Function} with a {@link Matrix} input.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface MatrixFunction<S, T> extends Function<Matrix<S>, T> {
}
