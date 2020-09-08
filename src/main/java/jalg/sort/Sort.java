package jalg.sort;

/**
 * interface for sorting algorithms.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 10 May 2019, 4:25 PM
 */
public interface Sort
{
    /**
     * method for sorting array
     *
     * @param unsorted an array to be sorted.
     * @return sorted array
     */
    <T extends Comparable<T>> T[] sort(T[] unsorted);

    /**
     * swap places in array
     *
     * @param array The array which elements to be swap
     * @param i     index of the first element
     * @param j     index of the second element
     */
    static <T> boolean swap(T[] array, int i, int j)
    {
        T swap = array[i];
        array[i] = array[j];
        array[j] = swap;
        return true;
    }

    /**
     * This method checks if first element is less then the other element
     *
     * @param v first element
     * @param w second element
     * @return true if the first element is less then the second element
     */
    static <T extends Comparable<T>> boolean less(T v, T w)
    {
        return v.compareTo(w) < 0;
    }

    /**
     * Swaps all position from {@param left} to @{@param right} for {@param array}
     *
     * @param array is an array
     * @param left  is a left flip border of the array
     * @param right is a right flip border of the array
     */
    static <T extends Comparable<T>> void flip(T[] array, int left, int right)
    {
        while (left <= right) {
            swap(array, left++, right--);
        }
    }

    /**
     * Test whether the array are in order.
     */
    static <T extends Comparable<T>> boolean isSorted(T[] a)
    {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    /**
     * print the array on a single line.
     */
    static void show(Comparable[] a)
    {
        for (Comparable comparable : a) System.out.print(comparable + " ");
        System.out.println();
    }
}
