package linalg.vector.computation;

import java.util.function.BiFunction;
import java.util.stream.IntStream;
import linalg.vector.Vector;
import linalg.vector.VectorGeneric;
import lombok.RequiredArgsConstructor;

/**
 * Generic binary {@link VectorComputation}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorComputationBinary<T> implements VectorComputation<T> {

    private final Vector<T> left;

    private final Vector<T> right;

    private final BiFunction<T, T, T> function;

    @Override
    public Vector<T> compute() {
        return new VectorGeneric<>(
            IntStream.range(0, this.left.dimension())
                .mapToObj(i -> this.function.apply(this.left.at(i), this.right.at(i)))
        );
    }

}
