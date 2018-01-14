package linalg.function;

/**
 * A differentiable {@link Function}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface DifferentiableFunction<S, T> extends Function<S, T> {

    Function<S, Function<S, T>> derivative();

}
