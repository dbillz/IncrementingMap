package dan;

import java.util.HashMap;

public class IncrementingMap<K> extends HashMap<K, Integer> {

	private final int incrementAmount;
	
	/**
	 * Get a new IncrementingMap which increments the key by the provided value
	 * every time insert is called.
	 * @param incrementAmount
	 */
	public IncrementingMap(int incrementAmount) {
		super();
		this.incrementAmount = incrementAmount;
	}
	
	/**
	 * Get a new IncrementingMap which increments the key by 1 every time insert is called.
	 */
	public IncrementingMap() {
		super();
		this.incrementAmount = 1;
	}
	
	/**
	 * Increment the count of this key in the map.
	 * @param key - the object being counted
	 */
	public void increment(K key) {
		int count = incrementAmount;
		if (containsKey(key)) {
			count = get(key) + incrementAmount;
		}
		put(key, count);
	}
	
	/**
	 * Decrement the count of this key in the map. 
	 * @param key - the object being counted
	 */
	public void decrement(K key) {
		int count = -incrementAmount;
		if (containsKey(key)) {
			count = get(key) - incrementAmount;
		}
		put(key, count);
	}
	
}
