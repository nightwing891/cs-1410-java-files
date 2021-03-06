package ac;

import java.util.Comparator;

/*
 * Data type that show the index of either the first or the 
 * last keys of searched items in a sorted array. 
 * 
 * @author Henry Doan
 * @version October 13, 2018
 */
public class BinarySearchDeluxe {
	
	/*
	 * Return the index of the first key in a[] that equals the search key, or -1 if no such key.
	 * 
	 * @param a -- incoming generic key array.
	 *        key -- search item.
	 *        comparator -- a way to order the keys.
	 * @return result -- the index of the first key or -1 if there is none.
	 */
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		// corner case
		if ( a == null || key == null || comparator == null ) {
			throw new java.lang.NullPointerException();
		}
		
		// start the binary search
		int low = 0;
		int high = a.length -1;
		int mid;
		
		// if the array is empty
		if (high == 0) return -1;
		
		// check if the order is the same
		if (comparator.compare(a[0], key) == 0) {
			return 0;
		}
		
		while(low <= high) {
			mid = low + (high - low) / 2;
			int comp = comparator.compare(key, a[mid]);
			
			if ( comp < 0) {
				high = mid - 1;
			} else if ( comp > 0) {
				low = mid + 1;
			} else if (comparator.compare(a[mid - 1], a[mid]) == 0) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		
		return -1;
		
	}
	
	/*
	 * Return the index of the last key in a[] that equals the search key, 
	 * or -1 if no such key.
	 * 
	 * @param a -- incoming generic key array.
	 *        key -- search item.
	 *        comparator -- a way to order the keys.
	 * @return result -- the index of the last key or -1 if there is none.
	 */
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if ( a == null || key == null || comparator == null ) {
			throw new java.lang.NullPointerException();
		}
		
		// start the binary search
		int low = 0;
		int high = a.length -1;
		int mid;
		
		// if the array is empty
		if (high == 0) return -1;

		// check if the order is the same
		if (comparator.compare(a[high], key) == 0) {
			return high;
		}
		
		while(low <= high) {
			mid = low + (high - low) / 2;
			int comp = comparator.compare(key, a[mid]);
			
			if ( comp < 0 ) {
				high = mid - 1;
			} else if ( comp > 0 ) {
				low = mid + 1;
			} else if ( comparator.compare(a[mid + 1], a[mid]) == 0 ) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
}
