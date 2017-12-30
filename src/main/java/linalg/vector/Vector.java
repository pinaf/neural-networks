package linalg.vector;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import linalg.scalar.Scalar;

/**
 * Vector.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface Vector<T> {

    int dimension();

    Scalar<T> at(int offset);

    default Stream<Scalar<T>> stream() {
        return IntStream.range(0, this.dimension()).mapToObj(this::at);
    }

}
