package jalg.heckerrank;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 May 2019, 1:43 PM
 */
public class RepeatedString
{
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n)
    {
        long mode = n % s.length();
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                a++;
            if (i == mode - 1)
                b = a;
        }

        return n / s.length() * a + b;
    }

}
