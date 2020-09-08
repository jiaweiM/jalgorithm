package jalg.heckerrank;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 May 2019, 4:25 PM
 */
public class StatDay0
{

    @Test
    public void weightedMean()
    {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());

        String[] values = scanner.nextLine().trim().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i]);
        }

        int[] weights = new int[N];
        values = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < values.length; i++) {
            weights[i] = Integer.parseInt(values[i]);
        }

        float sum = 0;
        float weighSum = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i] * weights[i];
            weighSum += weights[i];
        }

        System.out.println(String.format("%.1f", sum / weighSum));

        int n = 0;
        Scanner scanner1 = new Scanner(System.in);
        while (scanner1.hasNext()) {
            String s = scanner1.nextLine();
            n++;
            System.out.println(n + " " + s);
        }
        scanner1.close();
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());

        String s = scanner.nextLine();
        String[] values = s.split(" ");
        int[] array = new int[N];
        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i].trim());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int val : array) {
            sum += val;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int num = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                num = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                num = Math.min(num, entry.getKey());
            }
        }


        float avg = sum / (float) N;
        float median;
        Arrays.sort(array);
        if ((N % 2) == 0) {
            median = (array[N / 2] + array[N / 2 - 1]) / 2;
        } else
            median = (array[N / 2]);

        System.out.println(String.format("%f.1", avg));
        System.out.println(String.format("%f.1", median));
        System.out.println(num);
    }
}
