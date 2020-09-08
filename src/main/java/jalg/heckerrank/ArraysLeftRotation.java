package jalg.heckerrank;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 May 2019, 2:09 PM
 */
public class ArraysLeftRotation
{
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d)
    {
        int[] result = new int[a.length];
        System.arraycopy(a, 0, result, a.length - d, d);
        System.arraycopy(a, d, result, 0, a.length - d);
        return result;
    }

}
