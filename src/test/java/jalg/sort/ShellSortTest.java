package jalg.sort;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 11 Jun 2019, 3:51 PM
 */
public class ShellSortTest
{

    @Test
    public void testSort()
    {
        Integer[] array = new Integer[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        ShellSort shellSort = new ShellSort(new int[]{5, 2, 1});
        Integer[] sort = shellSort.sort(array);
        System.out.println(Arrays.toString(sort));
    }
}