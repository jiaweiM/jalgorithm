package jalg.heckerrank;

import org.testng.annotations.Test;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 08 May 2019, 10:56 PM
 */
public class JumpingOnClouds
{
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c)
    {
        int steps = 0;
        int i = 0;
        while (i < c.length) {
            if (i + 2 >= c.length - 1) {
                steps++;
                break;
            }
            if (c[i + 2] == 0) {
                i += 2;
            } else {
                i += 1;
            }
            steps++;
        }

        return steps;
    }

    @Test
    public void test1()
    {
        int[] in1 = new int[]{0, 0, 1, 0, 0, 1, 0};

        System.out.println(jumpingOnClouds(in1));
    }

}
