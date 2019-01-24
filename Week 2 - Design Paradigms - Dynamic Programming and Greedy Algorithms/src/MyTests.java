import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class MyTests {
	
	/*TODO: Add your own test cases here!
	 * We've provided a sample test case for each problem below
	 * You can use these as building blocks to write your own test cases
	 */
	
	@Test
	public void HuffmanSampleTest() {
		String input = "abc";
		Huffman h = new Huffman(input);
		String encoding = h.encode();
		assertEquals(input, h.decode(encoding));
		assertEquals("huffman abc compression", Huffman.compressionRatio(input), 0.20833, 0.01);
	}
	
	@Test
	public void IntervalSampleTest() {
		GreedyDynamicAlgorithms.Interval red = new GreedyDynamicAlgorithms.Interval(1, 3);
		GreedyDynamicAlgorithms.Interval blue = new GreedyDynamicAlgorithms.Interval(0, 4);
		ArrayList<GreedyDynamicAlgorithms.Interval> reds = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		reds.add(red);
		blues.add(blue);
		int expectedOptimal = 1;
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		assertEquals("interval 1 red 1 blue", expectedOptimal, actualOptimal);
	}

}