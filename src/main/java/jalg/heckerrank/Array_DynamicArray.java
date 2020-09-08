package jalg.heckerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 12 May 2019, 1:50 PM
 */
public class Array_DynamicArray
{
    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries)
    {
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }

        List<Integer> lastAnswers = new ArrayList<>();
        lastAnswers.add(0);
        int lastAnswer = 0;
        for (List<Integer> query : queries) {
            int index = (query.get(1) ^ lastAnswer) % n;

            List<Integer> seq = seqList.get(index);
            int y = query.get(2);
            if (query.get(0) == 1) {
                seq.add(y);
            } else {
                int newVal = y % seq.size();
                lastAnswer = seq.get(newVal);
                lastAnswers.add(lastAnswer);
            }
        }

        return lastAnswers;
    }

    public static void main(String[] args)
    {
        int n = 2;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 0, 5));
        queries.add(Arrays.asList(1, 1, 7));
        queries.add(Arrays.asList(1, 0, 3));
        queries.add(Arrays.asList(2, 1, 0));
        queries.add(Arrays.asList(2, 1, 1));

        List<Integer> integers = dynamicArray(n, queries);
        System.out.println(integers);
    }
}
