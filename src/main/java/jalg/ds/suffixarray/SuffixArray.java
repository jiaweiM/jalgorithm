package jalg.ds.suffixarray;

import java.util.Arrays;

/**
 * The {@code SuffixArray} class represents a suffix array of a string of
 * length <em>n</em>.
 * It supports the <em>selecting</em> the <em>i</em>th smallest suffix,
 * getting the <em>index</em> of the <em>i</em>th smallest suffix,
 * computing the length of the <em>longest common prefix</em> between the
 * <em>i</em>th smallest suffix and the <em>i</em>-1st smallest suffix,
 * and determining the <em>rank</em> of a query string (which is the number
 * of suffixes strictly less than the query string).
 * <p>
 * This implementation uses a nested class {@code Suffix} to represent
 * a suffix of a string (using constant time and space) and
 * {@code Arrays.sort()} to sort the array of suffixes.
 * The <em>index</em> and <em>length</em> operations takes constant time
 * in the worst case. The <em>lcp</em> operation takes time proportional to the
 * length of the longest common prefix.
 * The <em>select</em> operation takes time proportional
 * to the length of the suffix and should be used primarily for debugging.
 * <p>
 * For alternate implementations of the same API, see
 * {@link SuffixArrayX}, which is faster in practice (uses 3-way radix quicksort)
 * and uses less memory (does not create {@code Suffix} objects)
 * and <a href = "https://algs4.cs.princeton.edu/63suffix/SuffixArrayJava6.java.html">SuffixArrayJava6.java</a>,
 * which relies on the constant-time substring extraction method that existed
 * in Java 6.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/63suffix">Section 6.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class SuffixArray
{
    public static void main(String[] args)
    {
        System.out.println(Integer.MAX_VALUE);
    }

    private final String[] suffixes;
    private final int N;

    public SuffixArray(String s)
    {
        this.N = s.length();
        suffixes = new String[N];
        for (int i = 0; i < N; i++)
            suffixes[i] = s.substring(i);
        Arrays.sort(suffixes);
    }


    /**
     * @return length of text
     */
    public int length()
    {
        return N;
    }

    /**
     * ith in the suffix array (i between 0 and N-1)
     */
    public String select(int i)
    {
        return suffixes[i];
    }

    /**
     * index of ith sorted suffix
     *
     * @param i between 0 and N-1
     */
    public int index(int i)
    {
        return N - suffixes[i].length();
    }

    /**
     * length of longest common prefix of select(i) and select(i-1)
     *
     * @param i between 1 and N-1
     */
    public int lcp(int i)
    {
        return lcp(suffixes[i], suffixes[i - 1]);
    }

    /**
     * longest common prefix of suffixes(i) and suffixes(j)
     */
    public int lcp(int i, int j)
    {
        return lcp(suffixes[i], suffixes[j]);
    }

    /**
     * length of longest common prefix of s and t.
     */
    private static int lcp(String s, String t)
    {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++)
            if (s.charAt(i) != t.charAt(i)) return i;
        return N;
    }

    /**
     * number of suffixes less than key
     */
    public int rank(String key)
    {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(suffixes[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }
}
