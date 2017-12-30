package linalg.vector.computation;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import linalg.scalar.computation.ScalarComputation;
import linalg.vector.Vector;
import lombok.RequiredArgsConstructor;

/**
 * A generic, point-wise, accumulating {@link ScalarComputation} on two {@link Vector}s.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorScalarComputationBinary<T> implements ScalarComputation<T> {

    private final Vector<T> left;

    private final Vector<T> right;

    private final BiFunction<T, T, T> function;

    private final BinaryOperator<T> accumulator;

    @Override
    public T compute() {
        return IntStream.range(0, this.left.dimension())
            .mapToObj(i -> this.function.apply(this.left.at(i), this.right.at(i)))
            .reduce(this.accumulator).get();
    }

}
