package linalg.vector;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generic {@link Vector}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class VectorGeneric<T> implements Vector<T> {

    private final T[] data;

    @SuppressWarnings("unchecked")
    public VectorGeneric(final Stream<T> data) {
        this((T[]) data.toArray());
    }

    public VectorGeneric(final T... data) {
        this.data = data;
    }

    @Override
    public int dimension() {
        return this.data.length;
    }

    @Override
    public T at(final int offset) {
        return this.data[offset];
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(final Object obj) {
        return new VectorEquality<>(this).test(Vector.class.cast(obj));
    }

    @Override
    public String toString() {
        return String.format(
            "[%s]",
            Arrays.stream(this.data)
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );
    }

}
