
//DO NOT MODIFY THIS FILE
public class CompareInt implements Comparable<CompareInt> {
	
	public final int val;
	private int counter;
	
	public CompareInt(int val) {
		this.val = val;
		this.counter = 0;
	}
	
	public int getCount() {
		return counter;
	}
	
	public void reset() {
		counter = 0;
	}
	

	@Override
	public int compareTo(CompareInt o) {
		this.counter++;
		o.counter++;
		if (this.val < o.val) {
			return -1;
		} else if (this.val > o.val) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int countComparisons(CompareInt[] arr, int start, int end) {
		int total = 0;
		for (int i = start; i <= end; i++) {
			total += arr[i].getCount();
			arr[i].reset();
		}
		return total / 2; //each comparison is counted twice- once by each int in the comparison
	}
	
	public String toString() {
		return val + " ";
	}

}