package jalg.heckerrank;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 08 May 2019, 10:10 PM
 */
public class BigSum
{
    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar)
    {
        long sum = 0;
        for (long val : ar)
            sum += val;
        return sum;
    }
}
