package linalg.scalar.function;

import linalg.function.DifferentiableFunction;
import linalg.scalar.Scalar;

/**
 * A differentiable {@link ScalarFunction}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface DifferentiableScalarFunction<T> extends ScalarFunction<T>, DifferentiableFunction<Scalar<T>, Scalar<T>> {
}
