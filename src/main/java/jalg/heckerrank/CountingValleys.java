package jalg.heckerrank;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 07 May 2019, 9:27 PM
 */
public class CountingValleys
{
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s)
    {
        int count = 0;
        int val = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'U') {
                val++;
                if (val == 0)
                    count++;
            } else if (c == 'D')
                val--;
        }

        return count;
    }

}
