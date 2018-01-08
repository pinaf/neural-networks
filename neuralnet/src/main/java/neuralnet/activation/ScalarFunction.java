package neuralnet.activation;

import java.util.function.Function;
import linalg.scalar.Scalar;

/**
 * Scalar Function.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface ScalarFunction<T> extends Function<Scalar<T>, Scalar<T>> {
}
