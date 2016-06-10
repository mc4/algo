package leetcode;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 
 * @author MarkC
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key 
 * 	exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present. 
 * 	When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 */

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    
	private int capacity;
	
    public LRUCache(int capacity) {
    	super(capacity, 1.0f, true);
    	this.capacity = capacity;
    }
    
    public int get(int key) {
    	if(containsKey(key)){
    		return get(key);
    	}
        return -1;
    }
    
    public void set(int key, int value) {
    	if(!(containsKey(key)) && size() == capacity){
    		Set<Integer> keys = keySet();
    		int element = keys.iterator().next();
    		remove(element);
    	}
    	put(key, value);
    }
    
}
