package linalg.vector;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import linalg.scalar.Scalar;

/**
 * Generic {@link Vector}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class VectorGeneric<T> implements Vector<T> {

    private final Scalar<T>[] data;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public VectorGeneric(final Stream<Scalar<T>> data) {
        this.data = data.toArray(Scalar[]::new);
    }

    @Override
    public int dimension() {
        return this.data.length;
    }

    @Override
    public Stream<Scalar<T>> all() {
        return Arrays.stream(this.data);
    }

    @Override
    public Scalar<T> at(final int offset) {
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
