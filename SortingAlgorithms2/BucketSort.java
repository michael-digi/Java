import java.util.LinkedList;

public class BucketSort implements CostSort {

    private int cost;

    @Override
    public int[] sort(int[] data) {
	cost = 0;

	int min = data[0];
	for (int i = 1; i < data.length; i++) {
	    if (data[i] < min)
		min = data[i];
	}

	float[] temp = new float[data.length];


	for (int i = 0; i < data.length; i++) {
	    temp[i] = data[i] - min;
	}

	int max = data[0];
	for (int i = 1; i < data.length; i++) {
	    if (data[i] > max)
		max = data[i];
	}


	for (int i = 0; i < data.length; i++) {
	    temp[i] /= (max + 1);
	}

	bucketSort(temp);

	for (int i = 0; i < data.length; i++) {
	    temp[i] *= (max + 1);
	    temp[i] += min;
	    data[i] = (int) temp[i];
	}


	return data;
    }

    public void bucketSort(float[] data) {
	LinkedList<Float>[] buckets = new LinkedList[data.length];
	for (int i = 0; i < buckets.length; i++) {
	    buckets[i] = new LinkedList<>();
	}


	for (int i = 0; i < data.length; i++) {
	    buckets[(int) (data[i]  * data.length)].add(data[i]);
	}

	for (LinkedList<Float> bucket : buckets) {
	    insertionsort(bucket);
	}

	int i = 0;
	for (LinkedList<Float> bucket : buckets) {
	    for (Float num : bucket) {
		data[i++] = num;
	    }
	}

    }


    public void insertionsort(LinkedList<Float> data) {
	for (int j = 1; j < data.size(); j++) {
	    float key = data.get(j);
	    int i = j - 1;

	    while (i >= 0 && data.get(i) > key) {
		cost++;
		data.set(i+1, data.get(i));
		i--;
	    }

	    data.set(i+1, key);
	}
    }

    @Override
    public int cost() {
	return cost;
    }

}
