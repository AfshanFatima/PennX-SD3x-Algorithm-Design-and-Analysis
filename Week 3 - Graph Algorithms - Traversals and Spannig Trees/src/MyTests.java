import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

import java.util.*;

public class MyTests {
	
	@Test
	public void mazeSampleTest() throws IOException {
		Maze m = new Maze("files/mazeSmall.txt");
		List<Maze.Move> moves = m.solveMaze();
		assertEquals(2, moves.size());
		assertEquals(Maze.Move.DOWN, moves.get(0));
		assertEquals(Maze.Move.RIGHT, moves.get(1));
	}
	
	@Test
	public void testSmall() throws IOException {
		Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
		assertEquals(2, g.numShortestPaths(0, 3));
		assertEquals(2, g.numShortestPaths(1, 2));
		assertEquals(1, g.numShortestPaths(0, 1));
		assertEquals(1, g.numShortestPaths(2, 3));
	}

}