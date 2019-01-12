

/**
 * A Heap implementation class
 * 
 * @param heap the array that holds the heap data
 * @param size the number of elements currently stored in the heap
 */
public class MinHeap {
	
	CompareInt[] heap;
	int size;

	/**
	 * Constructs a new heap with maximum capacity n
	 * Remember to index your heap at 1 instead of 0!
	 * @param n the maximum number of elements allowed in the heap
	 */
	public MinHeap(int n) {
		heap = new CompareInt[n+1];
		size = 0;
	}
	
	/**
	 * Adds an element to the heap
	 * 
	 * @param val the value to be added to the heap
	 */
	public void add(CompareInt val) {
		if (size == heap.length - 1) throw new IllegalArgumentException();
//		System.out.println("adding " + val);
		size++;
		heap[size] = val;
		swim(size);
		return;
	}
	
	public void sink(int k) {
		while (2 * k <= size) {
			int min = Sorting.less(heap[2*k], heap[2*k + 1]) ? 2*k : 2*k + 1;
			if (Sorting.less(heap[k], heap[min]))
				break;
			
			Sorting.swap(heap, k, min);
			k = min;
		}
	}
	
	public void swim(int k) {
		System.out.println("Swim " + k);
		while (k > 1 && Sorting.less(heap[k],heap[k / 2])) {
			Sorting.swap(heap, k, k / 2);
			k /= 2;
		}
	}
	
	
	/**
	 * Extracts the smallest element from the heap
	 */
	public CompareInt extractMin() {
		CompareInt min = heap[1];
		heap[1] = heap[size];
		size--;
		sink(1);
		
		return min;
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			result += heap[i + 1].toString();
		}
		return result;
	}
	
	
}