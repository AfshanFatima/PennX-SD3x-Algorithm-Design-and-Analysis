import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

import java.util.*;

/*
 * NOTE: if you wish to create your own text files to write test cases for the Arbitrage question,
 * you may put them inside the "test" folder
 */
public class MyTests {
	
	/*
	 * the below file contains an arbitrage opportunity by following any of the below cycles of currencies:
	 * (note that in your implementation, any cycle will suffice)
	 * 0 -> 1 -> 2 -> 0
	 * 1 -> 2 -> 0 -> 1
	 * 2 -> 0 -> 1 -> 2
	 * 
	 * (for convenience, this is what the "2d array" that the file holds looks like):
     * 1.0 2.0 2.0
     * 0.5 1.0 1.5
     * 0.5 0.667 1.0
	 */
	@Test
	public void arbitrageTriangleSampleTest() throws IOException {
		String file = "arbitrageTriangle.txt";
		List<Integer> cycle = Arbitrage.arbitrageOpportunity(file);
		double[][] exchangeRates = Arbitrage.readExchangeRates(file);
		//check if the cycle that is outputted will yield an arbitrage opportunity
		int length = cycle.size();
		int start = cycle.get(0);
		int prev = start;
		double multiplier = 1.0;
		for (int i = 1; i < length; i++) {
			int next = cycle.get(i);
			multiplier *= exchangeRates[prev][next];
			prev = next;
		}
		assertEquals(start, prev); //the list should be cyclical
		assertEquals(1.5, multiplier, 0.0001);
	}
	
	/*
	 * MST must exist sample test
	 */
	@Test
	public void mustExistExample() {
		WeightedUndirectedGraphTest<MST.Weight> g = new WeightedUndirectedGraphTest<>(4);
		g.addEdge(0, 1, MST.Weight.MEDIUM);
		g.addEdge(0, 2, MST.Weight.MEDIUM);
		g.addEdge(1, 3, MST.Weight.MEDIUM);
		g.addEdge(2, 3, MST.Weight.LIGHT);
		Set<TupleTest> edges = MST.mustExist(g);
		assertEquals(1, edges.size());
		assertTrue(edges.contains(new TupleTest(2, 3)));
	}
	
	/*
	 * MST must not exist sample test
	 */
	@Test
	public void mustNotExistExample() {
		WeightedUndirectedGraphTest<MST.Weight> g = new WeightedUndirectedGraphTest<>(4);
		g.addEdge(0, 1, MST.Weight.MEDIUM);
		g.addEdge(0, 2, MST.Weight.MEDIUM);
		g.addEdge(1, 3, MST.Weight.MEDIUM);
		g.addEdge(2, 3, MST.Weight.LIGHT);
		Set<TupleTest> edges = MST.mustNotExist(g);
		assertEquals(0, edges.size());
	}
	
}