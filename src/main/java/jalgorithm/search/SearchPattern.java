package jalgorithm.search;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all
 * occurrences of pat[] in txt[]. You may assume that n > m.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Jul 2018, 2:34 PM
 */
public interface SearchPattern
{

    /**
     * Search pat in txt.
     *
     * @param txt
     * @param pat
     * @return
     */
    int[] search(String txt, String pat);

}
