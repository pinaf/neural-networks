package linalg.scalar;

/**
 * Scalar.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface Scalar<T> {

    T value();

    Scalar<T> sum(Scalar<T> addend);

    Scalar<T> product(Scalar<T> multiplicand);

    boolean isEqualTo(Scalar<T> other);

}
