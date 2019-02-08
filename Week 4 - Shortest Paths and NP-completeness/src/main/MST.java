
import java.util.*;

public class MST {
	
	/**
	 * This function takes in a graph, with weights classified as light, medium or heavy
	 * It should output a list of all edges in the graph that must be a part of
	 * any minimum spanning tree
	 * 
	 * You should use the Tuple class provided to output edges.  For instance, to output
	 * the edge (u,v), you would add "new Tuple(u,v)" to your list
	 * 
	 * @param g
	 * @return
	 */
	public static Set<TupleTest> mustExist(WeightedUndirectedGraphTest<Weight> g) {
		
		return null;
	}
	
    /**
	 * This function takes in a graph, with weights classified as light, medium or heavy
	 * It should output a list of all edges in the graph that must NOT be a part of
     * any minimum spanning tree
	 * 
	 * @param g
	 * @return the set of edges (unordered tuples of vertices) that must not
	 * exist in any MST
	 */
    public static Set<TupleTest> mustNotExist(WeightedUndirectedGraphTest<Weight> g) {
        //TODO
        return null;
    }

	/**
	 * Edges in this MST are classified as light, medium or heavy
	 * (their actual edge weights are not known)
	 */
	public enum Weight {
		LIGHT, MEDIUM, HEAVY
	}
	

}