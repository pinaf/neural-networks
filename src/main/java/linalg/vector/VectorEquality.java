package linalg.vector;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;

/**
 * Vector Equality.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorEquality<T> implements Predicate<Vector<T>> {

    private final Vector<T> vector;

    private final BiFunction<T, T, Boolean> comparison;

    public VectorEquality(final Vector<T> vector) {
        this(vector, Object::equals);
    }

    @Override
    public boolean test(final Vector<T> other) {
        return this.vector.dimension() == other.dimension() &&
            IntStream.range(0, this.vector.dimension())
                .allMatch(i -> this.comparison.apply(this.vector.at(i), other.at(i)));
    }

}
