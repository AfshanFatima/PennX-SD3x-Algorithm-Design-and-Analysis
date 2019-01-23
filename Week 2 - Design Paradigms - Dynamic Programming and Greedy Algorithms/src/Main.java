import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		// test Huffman
//		String input = "abcabacaa";
//		Huffman h = new Huffman(input);
//		String encoding = h.encode();
//		System.out.println(encoding);
//		String decoded = h.decode(encoding);
//		System.out.println(decoded);
		
		
		// test optimalGridPath
//		int[][] grid = new int[][]{
//			{5, 1, 1},
//			{20, 4, 7},
//			{30, 6, 3}
//		};
//		
//		int[][] min = new int[3][3];
//		List<GreedyDynamicAlgorithms.Direction> list = GreedyDynamicAlgorithms.optimalGridPath(grid);
//		for (GreedyDynamicAlgorithms.Direction dir : list) {
//			System.out.println(dir);
//		}
		
		
		// test optimalIntervals		
		// 1 blue 1 red
		System.out.println("Test 1 blue 1 red");
		GreedyDynamicAlgorithms.Interval red = new GreedyDynamicAlgorithms.Interval(1, 3);
		GreedyDynamicAlgorithms.Interval blue = new GreedyDynamicAlgorithms.Interval(0, 4);
		ArrayList<GreedyDynamicAlgorithms.Interval> reds = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		reds.add(red);
		blues.add(blue);
		
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		System.out.println(actualOptimal);
		
		// no possible solution
		System.out.println("Test no possible solution");
		red = new GreedyDynamicAlgorithms.Interval(5, 6);
		blue = new GreedyDynamicAlgorithms.Interval(0, 4);
		reds = new ArrayList<>();
		blues = new ArrayList<>();
		reds.add(red);
		blues.add(blue);		
		actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		System.out.println(actualOptimal);
		
		// 7 red 4 blue
		System.out.println("Test 7 red 4 blue");
		GreedyDynamicAlgorithms.Interval red1 = new GreedyDynamicAlgorithms.Interval(0, 4);
		GreedyDynamicAlgorithms.Interval red2 = new GreedyDynamicAlgorithms.Interval(2, 5);
		GreedyDynamicAlgorithms.Interval red3 = new GreedyDynamicAlgorithms.Interval(4, 8);
		GreedyDynamicAlgorithms.Interval red4 = new GreedyDynamicAlgorithms.Interval(9, 10);
		GreedyDynamicAlgorithms.Interval red5 = new GreedyDynamicAlgorithms.Interval(9, 11);
		GreedyDynamicAlgorithms.Interval red6 = new GreedyDynamicAlgorithms.Interval(10, 12);
		GreedyDynamicAlgorithms.Interval red7 = new GreedyDynamicAlgorithms.Interval(11, 12);
		reds = new ArrayList<>();
		reds.add(red1);
		reds.add(red2);
		reds.add(red3);
		reds.add(red4);
		reds.add(red5);
		reds.add(red6);
		reds.add(red7);
		
		GreedyDynamicAlgorithms.Interval blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		GreedyDynamicAlgorithms.Interval blue2 = new GreedyDynamicAlgorithms.Interval(5, 5);
		GreedyDynamicAlgorithms.Interval blue3 = new GreedyDynamicAlgorithms.Interval(7, 10);
		GreedyDynamicAlgorithms.Interval blue4 = new GreedyDynamicAlgorithms.Interval(11, 13);
		blues = new ArrayList<>();
		blues.add(blue1);
		blues.add(blue2);
		blues.add(blue3);
		blues.add(blue4);
		
		actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		System.out.println(actualOptimal);
		
		// 1 red 3 blue
		System.out.println("Test 1 red 3 blue");
		red1 = new GreedyDynamicAlgorithms.Interval(0, 6);
		reds = new ArrayList<>();
		reds.add(red1);
		blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		blue2 = new GreedyDynamicAlgorithms.Interval(5, 5);
		blue3 = new GreedyDynamicAlgorithms.Interval(3, 4);
		blues = new ArrayList<>();
		blues.add(blue1);
		blues.add(blue2);
		blues.add(blue3);
		actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		System.out.println(actualOptimal);
		
		// no overlap at all
		System.out.println("No overlap at all");
		red1 = new GreedyDynamicAlgorithms.Interval(1, 3);
		reds = new ArrayList<>();
		reds.add(red1);
		blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		blue2 = new GreedyDynamicAlgorithms.Interval(4, 4);
		blues = new ArrayList<>();
		blues.add(blue1);
		blues.add(blue2);
		actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		System.out.println(actualOptimal);
		
		test1();
		
	}
	
	public static void test1() {
		System.out.println("Test large interval 1");
		ArrayList<GreedyDynamicAlgorithms.Interval> reds = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		
		GreedyDynamicAlgorithms.Interval red1 = new GreedyDynamicAlgorithms.Interval(0, 4);
		GreedyDynamicAlgorithms.Interval red2 = new GreedyDynamicAlgorithms.Interval(2, 5);
		GreedyDynamicAlgorithms.Interval red3 = new GreedyDynamicAlgorithms.Interval(4, 8);
		GreedyDynamicAlgorithms.Interval red4 = new GreedyDynamicAlgorithms.Interval(9, 10);
		GreedyDynamicAlgorithms.Interval red5 = new GreedyDynamicAlgorithms.Interval(9, 11);
		GreedyDynamicAlgorithms.Interval red6 = new GreedyDynamicAlgorithms.Interval(10, 12);
		GreedyDynamicAlgorithms.Interval red7 = new GreedyDynamicAlgorithms.Interval(11, 12);
		GreedyDynamicAlgorithms.Interval red8 = new GreedyDynamicAlgorithms.Interval(13, 13);
		GreedyDynamicAlgorithms.Interval red9 = new GreedyDynamicAlgorithms.Interval(15, 16);
		GreedyDynamicAlgorithms.Interval red10 = new GreedyDynamicAlgorithms.Interval(18, 19);
		GreedyDynamicAlgorithms.Interval red11 = new GreedyDynamicAlgorithms.Interval(21, 21);
		GreedyDynamicAlgorithms.Interval red12 = new GreedyDynamicAlgorithms.Interval(25, 27);
		GreedyDynamicAlgorithms.Interval red13 = new GreedyDynamicAlgorithms.Interval(28, 28);
		GreedyDynamicAlgorithms.Interval red14 = new GreedyDynamicAlgorithms.Interval(30, 30);
		GreedyDynamicAlgorithms.Interval red15 = new GreedyDynamicAlgorithms.Interval(30, 31);
		GreedyDynamicAlgorithms.Interval red16 = new GreedyDynamicAlgorithms.Interval(32, 32);
		
		reds.add(red1);
		reds.add(red2);
		reds.add(red3);
		reds.add(red4);
		reds.add(red5);
		reds.add(red6);
		reds.add(red7);
		reds.add(red8);
		reds.add(red9);
		reds.add(red10);
		reds.add(red11);
		reds.add(red12);
		reds.add(red13);
		reds.add(red14);
		reds.add(red15);
		reds.add(red16);
		
		GreedyDynamicAlgorithms.Interval blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		GreedyDynamicAlgorithms.Interval blue2 = new GreedyDynamicAlgorithms.Interval(5, 5);
		GreedyDynamicAlgorithms.Interval blue3 = new GreedyDynamicAlgorithms.Interval(7, 10);
		GreedyDynamicAlgorithms.Interval blue4 = new GreedyDynamicAlgorithms.Interval(11, 13);
		GreedyDynamicAlgorithms.Interval blue5 = new GreedyDynamicAlgorithms.Interval(12, 12);
		GreedyDynamicAlgorithms.Interval blue6 = new GreedyDynamicAlgorithms.Interval(12, 14);
		GreedyDynamicAlgorithms.Interval blue7 = new GreedyDynamicAlgorithms.Interval(15, 16);
		GreedyDynamicAlgorithms.Interval blue8 = new GreedyDynamicAlgorithms.Interval(15, 18);
		GreedyDynamicAlgorithms.Interval blue9 = new GreedyDynamicAlgorithms.Interval(16, 17);
		GreedyDynamicAlgorithms.Interval blue10 = new GreedyDynamicAlgorithms.Interval(17, 18);
		GreedyDynamicAlgorithms.Interval blue11 = new GreedyDynamicAlgorithms.Interval(19, 21);
		GreedyDynamicAlgorithms.Interval blue12 = new GreedyDynamicAlgorithms.Interval(22, 26);
		GreedyDynamicAlgorithms.Interval blue13 = new GreedyDynamicAlgorithms.Interval(25, 25);
		GreedyDynamicAlgorithms.Interval blue14 = new GreedyDynamicAlgorithms.Interval(31, 32);
		GreedyDynamicAlgorithms.Interval blue15 = new GreedyDynamicAlgorithms.Interval(32, 32);

		
		blues.add(blue1);
		blues.add(blue2);
		blues.add(blue3);
		blues.add(blue4);
		blues.add(blue5);
		blues.add(blue6);
		blues.add(blue7);
		blues.add(blue8);
		blues.add(blue9);
		blues.add(blue10);
		blues.add(blue11);
		blues.add(blue12);
		blues.add(blue13);
		blues.add(blue14);
		blues.add(blue15);
		
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		System.out.println(actualOptimal);
	}
	
	
}