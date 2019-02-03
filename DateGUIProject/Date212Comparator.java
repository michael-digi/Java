import java.util.Comparator;

/**
 * Date212 Comparator is a class that is passed as an argument when the TreeMap is created, so anything fed through TreeMap utilizes the
 * Comparator. This class has a method called compare, which makes us of the compareTo method in our Datelist class. It goes sequentially through
 * the TreeMap and compares each date.
 *
 */

public class Date212Comparator implements Comparator<Date212> {
	
	public int compare(Date212 d1, Date212 d2) {
		
		 return d1.compareTo(d2);
	}
}
