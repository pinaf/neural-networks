package linalg.function;

import lombok.RequiredArgsConstructor;

/**
 * A composite {@link DifferentiableFunction}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CompositeDifferentiableFunction<R, S, T> implements DifferentiableFunction<R, T> {

    private final DifferentiableFunction<R, S> first;

    private final DifferentiableFunction<S, T> second;

    @Override
    public T at(final R input) {
        return new CompositeFunction<>(this.first, this.second).at(input);
    }

    @Override
    public Function<R, Function<R, T>> derivative() {
        return x -> h -> this.second.derivative().at(this.first.at(x))
            .at(this.first.derivative().at(x).at(h));
    }

}
