package linalg.vector;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * Wrap for {@link Vector}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@EqualsAndHashCode(of = "vector")
@RequiredArgsConstructor
public class VectorWrap<T> implements Vector<T> {

    private final Vector<T> vector;

    @Override
    public final int dimension() {
        return this.vector.dimension();
    }

    @Override
    public final T at(final int offset) {
        return this.vector.at(offset);
    }

    @Override
    public String toString() {
        return this.vector.toString();
    }

}
