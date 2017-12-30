package linalg.matrix;

import java.util.stream.Stream;
import linalg.scalar.Scalar;
import linalg.vector.Vector;

/**
 * Matrix.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface Matrix<T> {

    int rows();

    int columns();

    Stream<Vector<T>> allRows();

    Stream<Vector<T>> allColumns();

    Scalar<T> at(int row, int col);

    Vector<T> row(int row);

    Vector<T> column(int col);

}
