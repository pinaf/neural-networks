package neuralnet.activation;

/**
 * Activation function.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface ActivationFunction<T> extends ScalarFunction<T> {

    ScalarFunction<T> derivative();

}
