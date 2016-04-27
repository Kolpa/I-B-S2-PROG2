import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;

import de.kolpa.thb.pizzapronto.Bestellung;

public class JUnitTestBestellung {
	private static Bestellung best1;
	private static Bestellung best2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		best1 = new Bestellung(LocalDateTime.now(), LocalDateTime.MAX);
		best2 = new Bestellung(LocalDateTime.MIN, LocalDateTime.MAX);
	}
	
	@Test
	public void equalsInBestellung() {
		assertFalse(best1.equals(null));
		
		assertFalse(best1.equals(best2));
		
		assertTrue(best1.equals(best1));
	}

}
