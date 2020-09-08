package jalg.heckerrank;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 16 May 2019, 8:21 PM
 */
public class StatDay1
{
    @Test
    public void quartile()
    {
        int[] array = new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18};
        Arrays.sort(array);

        int q2 = getMedian(array);

        int q1 = 0;
        int q3 = 0;
        int N = array.length;
        if (N % 2 == 0) {
            q1 = getMedian(Arrays.copyOfRange(array, 0, N / 2));
            q3 = getMedian(Arrays.copyOfRange(array, N / 2, N));
        } else {
            q1 = getMedian(Arrays.copyOfRange(array, 0, N / 2));
            q3 = getMedian(Arrays.copyOfRange(array, N / 2 + 1, N));
        }
    }

    private static int getMedian(int[] array)
    {
        int N = array.length;
        if (N % 2 == 0) {
            return (array[N / 2] + array[N / 2 - 1]) / 2;
        } else
            return array[N / 2];
    }

    @Test
    public void interquartileRange()
    {
        int[] array = new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18};
        Arrays.sort(array);

        int q2 = getMedian(array);

        int q1 = 0;
        int q3 = 0;
        int N = array.length;
        if (N % 2 == 0) {
            q1 = getMedian(Arrays.copyOfRange(array, 0, N / 2));
            q3 = getMedian(Arrays.copyOfRange(array, N / 2, N));
        } else {
            q1 = getMedian(Arrays.copyOfRange(array, 0, N / 2));
            q3 = getMedian(Arrays.copyOfRange(array, N / 2 + 1, N));
        }
    }

    private static double getMedian(int[] array, int start, int end)
    {
        int N = end - start;
        if (N % 2 == 0)
            return (array[N / 2 + start] + array[N / 2 - 1 + start]) / 2.0;
        else
            return array[N / 2 + start];
    }

    @Test
    public void test()
    {
        int[] array = new int[]{6, 6, 6, 6, 6, 8, 8, 8, 10, 10, 12, 12, 12, 12, 16, 16, 16, 16, 16, 20, 20};
        System.out.println(getMedian(array, 0, 10));
        System.out.println(getMedian(array, 10, 20));
    }

    @Test
    public void testDeviation()
    {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        String[] items = scanner.nextLine().split(" ");
        int[] array = new int[N];
        int sum = 0;
        int x2 = 0;
        for (int i = 0; i < N; i++) {
            int item = Integer.parseInt(items[0]);
            x2 += item * item;
            sum += item;
        }
        scanner.close();

        double u = sum / (double) N;
        double std = Math.sqrt((double) x2 / N - u * u);
        System.out.println(std);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        String[] items = scanner.nextLine().split(" ");
        String[] freqs = scanner.nextLine().split(" ");
        int[] array = new int[N];
        int[] freq = new int[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(items[i]);
            freq[i] = Integer.parseInt(freqs[i]);
            size += freq[i];
        }
        scanner.close();

        int[] fArray = new int[size];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            int count = freq[i];
            for (int k = 0; k < count; k++) {
                fArray[index] = val;
                index++;
            }
        }
        Arrays.sort(fArray);
        double q1;
        double q3;
        if (size % 2 == 0) {
            q1 = getMedian(fArray, 0, size / 2);
            q3 = getMedian(fArray, size / 2, size);
        } else {
            q1 = getMedian(fArray, 0, size / 2);
            q3 = getMedian(fArray, size / 2 + 1, size);
        }

        System.out.printf("%.1f", q3 - q1);
    }
}
