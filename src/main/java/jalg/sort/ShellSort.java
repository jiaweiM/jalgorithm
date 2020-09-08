package jalg.sort;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 11 Jun 2019, 3:07 PM
 */
public class ShellSort implements Sort
{
    private int[] shells;

    public ShellSort(int[] shells)
    {
        this.shells = shells;
    }

    @Override public <T extends Comparable<T>> T[] sort(T[] unsorted)
    {
        int N = unsorted.length;
        for (int gap : shells) {
            for (int i = gap; i < N; i++) {
                int j = i;
                while (j - gap >= 0 && Sort.less(unsorted[j], unsorted[j - gap])) {
                    Sort.swap(unsorted, j, j - gap);
                    j -= gap;
                }
            }
        }
        return unsorted;
    }
}
