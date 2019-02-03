

public class CountingSort implements CostSort{

    private int cost;

    @Override
    public int[] sort(int[] data) {
	cost = 0;
	int[] B = new int[data.length];
	countSort(data, B, max(data));

	return B;
    }

    private int max(int[] data) {
	int max = data[0];
	for (int i = 1; i < data.length; i++) {
	    if(max < data[i])
		max = data[i];
	}

	return max;
    }

    private void countSort(int[] A, int[] B, int k){
	int[] C = new int[k + 1];
	for (int j = 0; j < A.length; j++) {
	    C[A[j]]++;
	}

	for (int i = 1; i <= k; i++) {
	    C[i] += C[i-1];
	}



	for (int i = A.length-1; i >= 0; i--) {
	    cost++;
	    B[C[A[i]] - 1] = A[i];
	    C[A[i]]--;
	}

    }

    @Override
    public int cost() {
	return cost;
    }


}
