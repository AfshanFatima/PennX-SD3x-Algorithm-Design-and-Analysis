

/**
 * A weighted, undirected graph class
 * 
 * E: the parameter for weights
 * For normal graphs, E will simply be a number (weights are numbers)
 * In the second part of the homework, weights will be put into 3 categories (using an enum)
 * 
 * *You do not have to modify this class*
 *
 */
public class WeightedUndirectedGraph<E> extends WeightedGraph<E> {

	public WeightedUndirectedGraph(int n) {
		super(n);
	}

	/**
	 * add an edge between vertices u and v with a value of type E
	 */
	@Override
	public void addEdge(int u, int v, E val) {
		adj[u].add(v); //add u to v's adjacency list
		adj[v].add(u); //add v to u's adjacency list
		//add the corresponding edge weight value
		weights[u][v] = val;
		weights[v][u] = val;
	}


}