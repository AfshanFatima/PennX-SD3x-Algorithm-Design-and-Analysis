import java.util.*;

/**
 * A weighted graph class
 * 
 * Note that we need to cast our weighted values to work with java generics.
 *
 */
public abstract class WeightedGraphTest<E> {
	
	protected int n; //number of vertices
	protected LinkedList<Integer>[] adj; //adjacency list
	//protected ArrayList<ArrayList<E>> weights; //a weight matrix
	protected Object[][] weights; // a weight matrix
	
	/**
	 * Constructs a graph with n vertices (containing no edges)
	 * 
	 * @param n - the number of vertices in the graph
	 */
	@SuppressWarnings("unchecked")
	public WeightedGraphTest(int n) {
		this.n = n;
		adj = (LinkedList<Integer>[]) new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
		weights = new Object[n][n];
//		weights = new ArrayList<>(n);
//		for (int i = 0; i < n; i++) {
//			weights.add(i, new ArrayList<>(n));
//		}
	}
	
	/**
	 * returns the value of the edge (u,v), or null if the edge does not exist
	 */
	@SuppressWarnings("unchecked")
	public E weight(int u, int v) {
		return (E) weights[u][v];
//		ArrayList<E> uList = weights.get(u);
//		return uList.get(v);
	}
	
	/**
	 * add an edge between vertices v and w with a weight value
	 */
	public abstract void addEdge(int v, int w, E val);
	
	/**
	 * outputs the neighbors of a vertex v
	 */
	public List<Integer> neighbors(int v) {
		return adj[v];
	}
	
	/**
	 * @return the number of vertices in the graph
	 */
	public int size() {
		return n;
	}
	
}