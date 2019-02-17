
/**
 * A simple tuple class to represent unordered pairs of vertices
 * 
 * Both functions that must be implemented in MST.java need to return
 * a list of edges, which we will represent as a list of tuples
 *
 */
public class TupleTest implements Comparable<TupleTest>{

	int u;
	int v;
	
	public TupleTest(int u, int v) {
		this.u = u;
		this.v = v;
	}
	
	//tuples are unordered
	@Override
	public boolean equals(Object other) {
		if (other instanceof TupleTest) {
			TupleTest o = (TupleTest) other;
			return (this.u == o.u && this.v == o.v) || (this.u == o.v && this.v == o.u);
		} else {
			return false;
		}
	}
	
	//compareTo is overridden, in case you wish to store Tuples in a TreeSet
	public int compareTo(TupleTest o) {
		int thisSum = this.u + this.v;
		int oSum = o.u + o.v;
		int thisMin = Math.min(this.u, this.v);
		int oMin = Math.min(o.u, o.v);
		if (thisSum < oSum) {
			return -1;
		} else if (thisSum > oSum) {
			return 1;
		} else {
			if (thisMin < oMin) {
				return -1;
			} else if (thisMin > oMin){
				return 1;
			} else {
				return 0;
			}
		}
	}
	
}