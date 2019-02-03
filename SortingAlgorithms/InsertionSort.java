
public class InsertionSort implements CostSort{

    private int cost;

    @Override
    public void sort(int[] data) {
	cost = 0;
	for (int j = 1; j < data.length; j++) {
	    int key = data[j];
	    int i = j - 1;

	    while (i >= 0 && data[i] > key) {
		cost++;
		data[i+1] = data[i];
		i--;
	    }

	    data[i+1] = key;
	}
    }

    @Override
    public int cost() {
	return cost;
    }


}
