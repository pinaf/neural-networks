package linalg.scalar.computation;

import linalg.scalar.Scalar;

/**
 * Scalar computation.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface ScalarComputation<T> {

    Scalar<T> compute();

}
