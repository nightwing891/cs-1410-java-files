package mergeSort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if      (i == mid)                 aux[k] = a[j++];
            else if (j == hi)                  aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else                               aux[k] = a[i++];
        }

        for (int k = lo; k < hi; k++)
            a[k] = aux[k];
    }


    @SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi - lo <= 1) return;

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);

        merge(a, aux, lo, mid, hi);
    }

    @SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, 0, n);
    }

    @SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, lo, hi);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }

    @SuppressWarnings("rawtypes")
	public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        assert isSorted(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}