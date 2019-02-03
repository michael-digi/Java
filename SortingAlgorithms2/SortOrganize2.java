import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortOrganize2 {

    public static void main(String[] args) throws FileNotFoundException {
	// sorts
	final CostSort[] SORTS = { new CountingSort(), new RadixSort(), new BucketSort() };

	// files
	final String[] INPUT_FILES = { "Num8.txt", "Num16.txt", "Num32.txt", "Num64.txt", "Num128.txt", "Num256.txt" };

	// size of each file
	int[] sizes = { 8, 16, 32, 64, 128, 256};

	// to store counters
	int[][] counts = new int[SORTS.length][INPUT_FILES.length];

	// to store sorted arrays
	int[][][] sortedArrays = new int[SORTS.length][INPUT_FILES.length][];

	// read arrays , sort and store results
	for (int sortNum = 0; sortNum < sortedArrays.length; sortNum++) {
	    CostSort sort = SORTS[sortNum];
	    for (int fileNum = 0; fileNum < INPUT_FILES.length; fileNum++) {
		int[] array = readArray(INPUT_FILES[fileNum], sizes[fileNum]);
		array = sort.sort(array);
		counts[sortNum][fileNum] = sort.cost();
		sortedArrays[sortNum][fileNum] = array;
	    }
	}

	// sort index
	// see sorts array
	int sortNum = 2;


	// UNCOMMENT TO PRINT SORTED ARRAYS
	// print results
	for (int i = 0; i < sizes.length; i++) {
	    System.out.println("\nNum" + sizes[i] + ".txt");
	    if (sizes[i] < 100)
		printArray(sortedArrays[sortNum][i], 0, sizes[i] - 1);
	    else
		printArray(sortedArrays[sortNum][i], 51, 100);
	}

	// to print the data ste size and number of steps taken
	System.out.printf("%-10s %-10s %-10s %-10s\n", "Size", "Counting", "Radix", "Bucket");
	for (int fileNum = 0; fileNum < INPUT_FILES.length; fileNum++) {
	    System.out.printf("%-10s",sizes[fileNum]);
	    for (sortNum = 0; sortNum < sortedArrays.length; sortNum++) {
		System.out.printf(" \t%s" ,counts[sortNum][fileNum]);
	    }
	    System.out.println();
	}

    }

    // print array
    public static void printArray(int[] a, int from, int to) {
	int count = 0;
	for (int i = from; i <= to; i++) {
	    System.out.print(a[i] + " ");
	    count++;
	    if(count % 10 ==0)
		System.out.println();
	}
	System.out.println();
    }

    // read array
    public static int[] readArray(String fileName, int size) throws FileNotFoundException {
	Scanner scanner = new Scanner(new File(fileName));
	int[] a = new int[size];
	for (int i = 0; i < a.length; i++) {
	    a[i] = scanner.nextInt();
	}
	scanner.close();
	return a;
    }
}
