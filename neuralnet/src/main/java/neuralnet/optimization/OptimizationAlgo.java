package neuralnet.optimization;

/**
 * Optimization Algorithm.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0
 */
public interface OptimizationAlgo<F, O> {

    O optimize();

}
