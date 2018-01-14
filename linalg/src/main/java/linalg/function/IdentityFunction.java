package linalg.function;

/**
 * Identity {@link Function}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public final class IdentityFunction<S> implements Function<S, S> {

    @Override
    public S at(final S input) {
        return input;
    }

}
