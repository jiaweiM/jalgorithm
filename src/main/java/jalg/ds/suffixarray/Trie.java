package jalg.ds.suffixarray;

/**
 * Java implementation of search and insert operations on Trie
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 11 Jan 2019, 8:06 PM
 */
public class Trie
{
    // Alphabet size
    static final int ALPHABET_SIZE = 26;

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        /**
         * is EndOfWord is true if the node represents end of a word
         */
        boolean isEndOfWord;

        TrieNode()
        {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root;

    /**
     * if not present, inserts key into trie, if the key is prefix of trie node,
     * just marks leaf node
     */
    static void insert(String key)
    {

    }
}
