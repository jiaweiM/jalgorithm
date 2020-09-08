package jalg.sort;

import java.util.Arrays;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 11 Jun 2019, 4:44 PM
 */
public class RadixSort
{
    private static final int NUMBER_OF_BUCKETS = 10; // 10 for base 10 numbers

    private RadixSort() { }

    public static Integer[] sort(Integer[] unsorted)
    {
        int[][] buckets = new int[NUMBER_OF_BUCKETS][10];
        for (int i = 0; i < NUMBER_OF_BUCKETS; i++)
            buckets[i][0] = 1; // Size is one since the size is stored in first element
        int numberOfDigits = getMaxNumberOfDigits(unsorted); // Max number of digits
        int divisor = 1;
        for (int n = 0; n < numberOfDigits; n++) {
            int digit = 0;
            for (int d : unsorted) {
                digit = getDigit(d, divisor);
                buckets[digit] = add(d, buckets[digit]);
            }
            int index = 0;
            for (int i = 0; i < NUMBER_OF_BUCKETS; i++) {
                int[] bucket = buckets[i];
                int size = bucket[0];
                for (int j = 1; j < size; j++) {
                    unsorted[index++] = bucket[j];
                }
                buckets[i][0] = 1; // reset the size
            }
            divisor *= 10;
        }
        return unsorted;
    }

    private static int getMaxNumberOfDigits(Integer[] unsorted)
    {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i : unsorted) {
            temp = (int) Math.log10(i) + 1;
            if (temp > max)
                max = temp;
        }
        return max;
    }

    private static int getDigit(int integer, int divisor)
    {
        return (integer / divisor) % 10;
    }

    private static int[] add(int integer, int[] bucket)
    {
        int size = bucket[0]; // size is stored in first element
        int length = bucket.length;
        int[] result = bucket;
        if (size >= length) {
            result = Arrays.copyOf(result, ((length * 3) / 2) + 1);
        }
        result[size] = integer;
        result[0] = ++size;
        return result;
    }
}
