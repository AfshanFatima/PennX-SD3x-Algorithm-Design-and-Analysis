import java.util.Arrays;

public class Sorting {
	
	/**
	 * Implement the mergesort function, which should sort the array of
	 * integers in place
	 * 
	 * You will probably want to use helper functions here, as described in the lecture recordings
	 * (ex. merge(), a helper mergesort function)
	 * @param arr
	 */
	public static void mergeSort(CompareInt[] arr) {
		//TODO
		CompareInt[] aux = new CompareInt[arr.length];
		sort(arr, aux, 0, arr.length - 1);
	}
	
	public static void sort(CompareInt[] arr, CompareInt[] aux, int low, int high) {
		if (high <= low) return;
		int mid = (high + low) / 2; // = low + (high - low) / 2
		sort(arr, aux, low, mid);
		sort(arr, aux, mid + 1, high);
		merge(arr, aux, low, mid, high);
		Arrays.toString(arr);
	}
	
	public static void merge(CompareInt[] arr, CompareInt[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = arr[i];
		}
		
		int i = lo; int j = mid + 1; int k = lo;
		
		while (i <= mid && j <= hi) {
			if (less(aux[i], aux[j])) {
				arr[k++] = aux[i++];
			} else {
				arr[k++] = aux[j++];
			}
		}
		
		while (i <= mid) {
			arr[k++] = aux[i++];
		}
		while (j <= hi) {
			arr[k++] = aux[j++];
		}
	}
	
	// is x < y ?
	public static boolean less(CompareInt x, CompareInt y) {
		return x.compareTo(y) < 0;
	}
	
	// swap arr[i] and arr[j]
	public static void swap(CompareInt[] arr, int i, int j) {
		CompareInt tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static int partition(CompareInt[] arr, int lo, int hi) {
		System.out.println("lo : " + lo + " hi: " + hi);
		CompareInt pivot = arr[lo];
		int i = lo; int j = hi+1;
		while (true) {
			printArr(arr);
			while (less(arr[++i], pivot)) // find next i that a[i] > pivot
				if (i == hi) break;
			
			while (less(pivot, arr[--j])) // find next j that a[j] < pivot
				if (j == lo) break;
			
			if (i >= j) break;
			System.out.println("Swapping a[" + i + "] = " + arr[i] + "a[" + j + "] = " + arr[j]);
			swap(arr, i, j);
		}
		
		swap(arr, lo, j);
		System.out.println("Final: ");
		printArr(arr);
		System.out.println(arr[j]);
		return j;
	}
	
	public static void printArr(CompareInt[] arr) {
		for (CompareInt i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}
	
	public static CompareInt quick(CompareInt[] arr, int k, int lo, int hi) {
		if (lo == hi) return arr[lo];
		
		
		int pivot = partition(arr, lo, hi);
		System.out.println("k = " + k + " pivot = " + pivot);
		if (pivot == k) {
			return arr[k];
		}
		
		if (pivot < k)
			return quick(arr, k, pivot + 1, hi);
		else 
			return quick(arr, k, lo, pivot - 1);
	}
	
	/**
	 * Implement the quickSelect
	 * 
	 * Again, you will probably want to use helper functions here
	 * (ex. partition(), a helper quickselect function)
	 */
	public static CompareInt quickSelect(int k, CompareInt[] arr) {
		//TODO
		return quick(arr, k-1, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		CompareInt[] arr = MyTests.convert(new int[]{4, 3, 5, 10, 2, 0, 9, 8});
//		MinHeap h = new MinHeap(arr.length);
//		for (int i = 0; i < arr.length; i++) {
//			h.add(arr[i]);
//			System.out.println(h);
//		}
		MinHeap h = new MinHeap(1);
		h.add(new CompareInt(100));
//		h.add(new CompareInt(200));
		
		for (int i = 0; i < arr.length-1; i++) {
			System.out.println("extracting min " + h.extractMin());
			System.out.println(h);
		}

		
//		System.out.println(arr[partition(arr, 0, arr.length - 1)]);
		
//		System.out.println(quickSelect(7, arr));
//		printArr(arr);
		
		
//		Arrays.toString(arr);
	}

}