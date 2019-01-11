public class KthSmallest {
	
	/*
	 * You do not have to modify this file
	 * you should read through each of the sorting implementations and understand how they work
	 * before attempting to implement the other files!
	 */
	
	private static int mergeSortComparisons;
	private static int quickSelectComparisons;
	private static int minHeapComparisons;
	
	/**
	 * extracts the kth smallest element from an array
	 * using your implementation of mergesort
	 */
	public static int mergeSortImpl(int k, CompareInt[] arr) {
		Sorting.mergeSort(arr);
		mergeSortComparisons = CompareInt.countComparisons(arr, 0, arr.length - 1);
		return arr[k-1].val; //arr[k-1] is the kth smallest element in the sorted array
	}
	
	/**
	 * extracts the kth smallest element from an array
	 * using your implementation of quick-select
	 */
	public static int quickSelectImpl(int k, CompareInt[] arr) {
		int select = Sorting.quickSelect(k, arr).val;
		quickSelectComparisons = CompareInt.countComparisons(arr, 0, arr.length - 1);
		return select;
	}
	
	/**
	 * extracts the kth smallest element from an array
	 * using your implementation of the MinHeap class
	 * 
	 */
	public static int heapImpl(int k, CompareInt[] arr) {
		MinHeap h = new MinHeap(arr.length);
		//add all the elements to a min-heap
		for (int i = 0; i < arr.length; i++) {
			h.add(arr[i]);
		}
		//remove the first k-1 elements (i.e. the k-1 smallest element)
		for (int i = 0; i < k-1; i++) {
			h.extractMin();
		}
		minHeapComparisons = CompareInt.countComparisons(arr, 1, arr.length - 1);
		//the next smallest element in the min-heap is the kth smallest element
		return h.extractMin().val;
	}
	
	public static int getMergeSortComparisons() {
		return mergeSortComparisons;
	}
	
	public static int getQuickSelectComparisons() {
		return quickSelectComparisons;
	}
	
	public static int getMinHeapComparisons() {
		return minHeapComparisons;
	}
	
}