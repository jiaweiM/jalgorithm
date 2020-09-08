package jalg.sort;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 10 Jun 2019, 9:56 PM
 */
public class SelectionSort implements Sort
{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted)
    {
        int N = unsorted.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Sort.less(unsorted[j], unsorted[min])) min = j;
            }
            Sort.swap(unsorted, i, min);
        }
        return unsorted;
    }
}
