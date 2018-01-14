package linalg.vector.computation;

import linalg.function.Function;
import linalg.scalar.Scalar;
import linalg.vector.Vector;
import linalg.vector.VectorGeneric;
import lombok.RequiredArgsConstructor;

/**
 * Point-wise {@link Vector} function.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class VectorPointwiseFuncion<T> implements VectorComputation<T> {

    private final Vector<T> vector;

    private final Function<Scalar<T>, Scalar<T>> function;

    @Override
    public Vector<T> compute() {
        return new VectorGeneric<>(this.vector.stream().map(this.function::at));
    }

}
