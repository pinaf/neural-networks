package neuralnet;

/**
 * A Layer for a Neutral Network.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface NNLayer<F, B> {

    F forward(F signal);

    B backward(B signal);

}
