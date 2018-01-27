package neuralnet.optimization;

import linalg.function.DifferentiableFunction;
import linalg.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import neuralnet.NeuralNet;

/**
 * Gradient Descent {@link OptimizationAlgo}.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
@Slf4j
@RequiredArgsConstructor
public final class GradientDescent<F, O> implements OptimizationAlgo<F, O> {

    private final NeuralNet<F, Function<F, O>> net;

    private final DifferentiableFunction<F, O> cost;

    private final F input;

    private final int iterations;

    @Override
    public O optimize() {
        O cost = null;
        for (int iter = 0; iter < this.iterations; ++iter) {
            log.info("Iteration: {}", iter);
            cost = this.cycle();
        }
        return cost;
    }

    private O cycle() {
        //log.info("Input: {}", this.input);
        final F output = this.net.forward(this.input);
        //log.info("Output: {}", output);
        final O cst = this.cost.at(output);
        log.info("Cost: {}", cst);
        final Function<F, O> cdiff = this.cost.derivative().at(output);
        //log.info("DCost: {}", cdiff.at(new MatrixBigDecimal(output.rows(), output.columns(), BigDecimal.ONE)));
        this.net.backward(cdiff);
        return cst;
    }

}
