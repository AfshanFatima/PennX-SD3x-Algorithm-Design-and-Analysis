import java.util.*;
import java.io.*;

/**
 * Arbitrage class
 *
 */
public class Arbitrage {
	
	/**
	 * 
	 * This function reads in a file containing exchange rate information
	 * (we've done this for you),
	 * and should create a weighted, directed graph
	 * 
	 * The output should be a list of currencies (i.e. vertices) that you can follow
	 * to create an arbitrage opportunity
	 * 
	 * e.x. if trading from currency 1 to 2 to 3 back to 1 yields an arbitrage
	 * opportunity, you should output a list containing {1, 2, 3, 1}
	 * 
	 * If no arbitrage opportunity is present, you should output an empty list
	 */
	public static List<Integer> arbitrageOpportunity(String filename) throws IOException {
		
		//parses the input file into a list of exchange rates
		//see the comments above readExchangeRates for details on its output
		double[][] exchangeRates = readExchangeRates(filename);
		
		//TODO: model the exchange rates as a graph and output the value of
		//an arbitrage opportunity (see the writeup)
		return null;
	}
	
	
	/**
	 * You don't have to modify this function
	 * 
	 * Parses a file containing exchange rates between countries into an NxN 2d array
	 * 
	 * In general, if we have two countries i and j,
	 * arr[i][j] gives the exchange rate from country i to j.
	 * 
	 * I.e. if arr[i][j] = 4.00, then 1 quantity of currency i can be exchanged
	 * for 4.00 quantities of currency j
	 */
	public static double[][] readExchangeRates(String filename) throws IOException {
		//System.out.println("starting to read exchange rates");
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		//first line contains the number of countries
		int n = Integer.parseInt(br.readLine());
		double[][] exchangeRates = new double[n][n];
		
		//parse the file as a 2d array
		//in general, element j in row i has the exchange rate from country i to country j
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				double rate = Double.parseDouble(line[j]);
				exchangeRates[i][j] = rate;
			}
		}
		br.close();
		return exchangeRates;
		
	}

}