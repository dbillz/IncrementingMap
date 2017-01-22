package dan;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;


public class IncrementingMapTest {
	private static final String FIRST_KEY = "first";
	private static final int NUM_FIRST_KEY = 11;
	private static final String SECOND_KEY = "second";
	private static final int NUM_SECOND_KEY = 32;
	private static final String THIRD_KEY = "third";

	@Test
	public void testIncrement() {
		IncrementingMap<String> map = new IncrementingMap<>();
		IntStream.range(0, NUM_FIRST_KEY).forEach(i -> map.increment(FIRST_KEY));
		IntStream.range(0, NUM_SECOND_KEY).forEach(i -> map.increment(SECOND_KEY));
		
		Assert.assertEquals("First key count mismatch", NUM_FIRST_KEY, (int) map.get(FIRST_KEY));
		Assert.assertEquals("Second key count mismatch", NUM_SECOND_KEY, (int) map.get(SECOND_KEY));
	}
	
	@Test
	public void testDecrement() {
		IncrementingMap<String> map = new IncrementingMap<>();

		IntStream.range(0, NUM_FIRST_KEY).forEach(i -> map.increment(FIRST_KEY));
		IntStream.range(0, NUM_SECOND_KEY).forEach(i -> map.increment(SECOND_KEY));
		IntStream.range(0, NUM_FIRST_KEY).forEach(i -> map.decrement(FIRST_KEY));
		map.decrement(THIRD_KEY);
		
		Assert.assertEquals("First key should be decremented to zero", 0, (int) map.get(FIRST_KEY));
		Assert.assertEquals("Second key count mismatch", NUM_SECOND_KEY, (int) map.get(SECOND_KEY));
		Assert.assertEquals("Third key should be decremented to -1", -1, (int) map.get(THIRD_KEY));
	}
}
