
public class MergeSort implements CostSort {

    private int cost;

    @Override
    public void sort(int[] data) {
	cost = 0;
	mergesort(data, 0, data.length - 1);
    }

    private void mergesort(int[] a, int p, int r) {
	if (p < r) {
	    int q = (p + r) / 2;
	    mergesort(a, p, q);
	    mergesort(a, q + 1, r);
	    merge(a, p, q, r);
	}

    }

    private void merge(int[] A, int p, int q, int r) {
	final int INFINITY = Integer.MAX_VALUE;

	int n1 = q - p + 1;
	int n2 = r - q;

	int[] L = new int[n1 + 1];
	int[] R = new int[n2 + 1];

	for (int i = 1; i <= n1; i++) {
	    L[i - 1] = A[p + i - 1];
	}

	for (int j = 1; j <= n2; j++) {
	    R[j - 1] = A[q + j];
	}

	L[n1] = INFINITY;
	R[n2] = INFINITY;

	int i = 0, j = 0;

	for (int k = p; k <= r; k++) {
	    cost++;
	    if (L[i] <= R[j]) {
		A[k] = L[i];
		i++;
	    } else {
		A[k] = R[j];
		j++;
	    }
	}

    }

    @Override
    public int cost() {
	return cost;
    }

}
