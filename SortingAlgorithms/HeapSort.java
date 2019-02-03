
public class HeapSort implements CostSort {

    private int cost;

    public void sort(int[] data) {
	cost = 0;
	heapSort(data);
    }

    private void heapSort(int[] A) {
	buildMaxHeap(A);

	int heapSize = A.length;
	for (int i = A.length - 1; i >= 0; i--) {
	    swap(A, 0, i);
	    heapSize--;
	    maxHeapify(A, 0, heapSize);
	}
    }

    private void buildMaxHeap(int[] A) {
	int heapSize = A.length;
	for (int i = heapSize / 2; i >= 0; i--) {
	    maxHeapify(A, i, heapSize);
	}
    }

    private void maxHeapify(int[] A, int i, int heapSize) {
	int l = 2 * i + 1;
	int r = 2 * i + 2;

	int largest;

	if (l < heapSize && A[l] > A[i]) {
	    largest = l;
	} else
	    largest = i;

	if (r < heapSize && A[r] > A[largest])
	    largest = r;

	if (largest != i) {
	    swap(A, i, largest);
	    cost++;
	    maxHeapify(A, largest, heapSize);
	}
    }

    // to swap two numbers
    public void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    @Override
    public int cost() {
	return cost;
    }

}
