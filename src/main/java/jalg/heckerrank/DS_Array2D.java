package jalg.heckerrank;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 May 2019, 1:57 PM
 */
public class DS_Array2D
{
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr)
    {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                largest = Math.max(sum, largest);
            }
        }
        return largest;
    }
}
