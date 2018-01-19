package neuralnet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.ToString;

/**
 * Default, layered {@link NeuralNet}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@ToString
public final class NeuralNetDefault<F, B> implements NeuralNet<F, B> {

    private final List<NNLayer<F, B>> layers;

    public NeuralNetDefault(final NNLayer<F, B> head, final NNLayer<F, B>... tail) {
        this.layers = Stream.concat(Stream.of(head), Arrays.stream(tail))
            .collect(Collectors.toList());
    }

    @Override
    public F forward(final F signal) {
        F current = signal;
        for (final NNLayer<F, B> layer : this.layers) {
            current = layer.forward(current);
        }
        return current;
    }

    @Override
    public B backward(final B signal) {
        B current = signal;
        for (int idx = this.layers.size() - 1; idx >= 0; --idx) {
            current = this.layers.get(idx).backward(current);
        }
        return current;
    }

}
