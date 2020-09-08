package jalg.sort;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 11 Jan 2019, 10:08 PM
 */
public class InsertSort implements Sort
{
    @Override public <T extends Comparable<T>> T[] sort(T[] unsorted)
    {
        int N = unsorted.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Sort.less(unsorted[j], unsorted[j - 1]); j--) {
                Sort.swap(unsorted, j, j - 1);
            }
        }
        return unsorted;
    }
}
