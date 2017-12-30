package linalg.matrix.computation;

import linalg.matrix.Matrix;

/**
 * Matrix computation.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface MatrixComputation<T> {

    Matrix<T> compute();

}
