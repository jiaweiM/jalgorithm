package jalg.sort;

/**
 * implementation of bubble sort.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 10 May 2019, 4:26 PM
 */
public class BubbleSort implements Sort
{
    @Override public <T extends Comparable<T>> T[] sort(T[] unsorted)
    {
        int last = unsorted.length;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < last - 1; i++) {
                if (Sort.less(unsorted[i], unsorted[i + 1]))
                    swap = Sort.swap(unsorted, i, i + 1);
            }
            last--;
        } while (swap);
        return unsorted;
    }
}
