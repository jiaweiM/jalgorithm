package jalg.heckerrank;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.testng.Assert.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 10 May 2019, 4:57 PM
 */
public class ArrayManipulation
{
    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a)
    {
        for (int i = 0; i < a.length / 2; i++) {
            int val = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = val;
        }

        return a;
    }

    @Test
    public void testReverse()
    {
        int[] a = new int[]{1, 4, 3, 2};
        System.out.println(Arrays.toString(reverseArray(a)));
    }

    static int[] shiftArray(int[] a, int n)
    {
        int[] f = new int[a.length];
        System.arraycopy(a, 0, f, a.length - n, n);
        System.arraycopy(a, n, f, 0, a.length - n);
        return f;
    }

    @Test
    public void testShift()
    {
        int[] array = new int[]{1, 2, 3, 4, 5};
        assertEquals(shiftArray(array, 4), new int[]{5, 1, 2, 3, 4});
    }

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries)
    {
        int[] result = new int[queries.length];
        Arrays.fill(result, 0);
        HashMap<String, Integer> map = new HashMap<>(queries.length);
        for (int i = 0; i < queries.length; i++) {
            map.put(queries[i], i);
        }
        for (String val : strings) {
            Integer index = map.get(val);
            if (index != null)
                result[index]++;
        }
        return result;
    }

    static int[] matchingStrings2(String[] strings, String[] queries)
    {
        int[] result = new int[queries.length];
        for(int i = 0; i< queries.length; i++){
            String val = queries[i];
            for(String val2 : strings){
                if(val.equals(val2))
                    result[i]++;
            }
        }
        return result;
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries)
    {
        long[] arr = new long[n];
        for (int[] query : queries) {
            arr[query[0] - 1] += query[2];
            if (query[1] < n)
                arr[query[1]] -= query[2];
        }

        long temp = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            temp += arr[i];
            if (temp > max) max = temp;
        }
        return max;
    }

    @Test
    public void test()
    {
        int n = 5;
        int[][] queries = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
        System.out.println(queries.length);
        System.out.println(Arrays.toString(queries[0]));
        System.out.println(Arrays.toString(queries[1]));
        System.out.println(Arrays.toString(queries[2]));
        System.out.println(arrayManipulation(n, queries));
    }
}
