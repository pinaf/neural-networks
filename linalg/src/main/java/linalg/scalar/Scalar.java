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

    Scalar<T> difference(Scalar<T> subtrahend);

    Scalar<T> product(Scalar<T> multiplicand);

    Scalar<T> quotient(Scalar<T> dividend);

    boolean isEqualTo(Scalar<T> other);

    Scalar<T> zero();

    Scalar<T> one();

    Scalar<T> negate();

}
