package linalg.function;

/**
 * Generic function.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface Function<S, T> {

    T at(S input);

}
