package jalg.heckerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 07 May 2019, 9:18 PM
 */
public class SockMerchant
{
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar)
    {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int color = ar[i];
            if (set.contains(color)) {
                count++;
                set.remove(color);
            } else
                set.add(color);
        }
        return count;
    }
}
