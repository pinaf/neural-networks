package linalg.vector;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Vector.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface Vector<T> {

    int dimension();

    T at(int offset);

    default Stream<T> stream() {
        return IntStream.range(0, this.dimension()).mapToObj(this::at);
    }

}
