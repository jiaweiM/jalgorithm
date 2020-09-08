package jalg.heckerrank;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 May 2019, 2:27 PM
 */
public class NewYearChaos
{
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q)
    {
        for (int i = 0; i < q.length - 1; i++) {
            if (q[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
        }
        int count = 0;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < q.length - 1; i++) {
                if (q[i] > q[i + 1]) {
                    count++;
                    swap = true;
                    int val = q[i];
                    q[i] = q[i + 1];
                    q[i + 1] = val;
                }
            }
        } while (swap);

        System.out.println(count);
    }
}
