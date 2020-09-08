package jalgorithm.search;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Jan 2019, 12:08 PM
 */
public interface ST<Key, Value>
{
    /**
     * put key-value pair into the table
     * remove key from table if value is null
     */
    void put(Key key, Value value);

    /**
     * @param key key
     * @return value paired with key, null if key is absent
     */
    Value get(Key key);

    /**
     * remove key (and its value) from table
     */
    void delete(Key key);

    /**
     * is there a value paired with key?
     */
    boolean contains(Key key);

    /**
     * is the table empty?
     */
    boolean isEmpty();

    /**
     * @return number of key-value pairs in the table
     */
    int size();

    /**
     * all the keys in the table
     */
    Iterable<Key> keys();
}
