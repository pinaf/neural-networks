package linalg.function;

import lombok.RequiredArgsConstructor;

/**
 * A composite {@link Function}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CompositeFunction<R, S, T> implements Function<R, T> {

    private final Function<R, S> first;

    private final Function<S, T> second;

    @Override
    public T at(final R input) {
        return this.second.at(this.first.at(input));
    }

}
