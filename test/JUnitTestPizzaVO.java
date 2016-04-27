import org.junit.BeforeClass;import org.junit.Test;import de.kolpa.thb.pizzapronto.PizzaVO;import static org.junit.Assert.*;/** * Die Methoden der Klasse PizzaVO werden getestet. *  * Zum Testen werden spezielle Assert-Befehle eingesetzt <br> *  * @author Gabriele Schmidt * @version 1.0 28.03.2014 */public class JUnitTestPizzaVO {	private static PizzaVO pizzaIni;		private static PizzaVO pizzaX, pizzaY, pizzaZ;	@BeforeClass	public static void setUpBeforeClass() throws Exception {		pizzaIni = new PizzaVO("Marghrita",new String [] {"Tomaten","K�se","Basilikum"},8.0f);	}	@Test	public void cloneInPizzaVO() {		assertEquals(pizzaIni.getClass()				+ " erstellt eine Kopie mit der clone Methode", pizzaIni,				pizzaIni.clone());		assertFalse("Clone der  " + pizzaIni.getClass()				+ " erstellt eine echte Kopie",				pizzaIni == pizzaIni.clone());	}	@Test	public void werteInPizzaVO() {		assertTrue(pizzaIni.getClass() + " nicht negativer Preis ",				pizzaIni.getPreis() >= 0);	}		@Test	public void equalsInPizzaVO() {		pizzaX = new PizzaVO("Marghrita",new String [] {"Tomaten","K�se","Basilikum"},8.0f);		pizzaY =  new PizzaVO("Marghrita",new String [] {"Tomaten","K�se","Basilikum"},8.0f);		pizzaZ =  new PizzaVO("Marghrita",new String [] {"Tomaten","K�se","Basilikum"},8.0f);				//For any non-null reference value x, x.equals(null) should return false. 		assertFalse("For any non-null reference value x, x.equals(null) should return false.", pizzaX.equals(null));						//Zwei Objekte		assertTrue(pizzaY.getClass() + " erstellt mit dem Initialisierungskonstruktor neue Objekte ", pizzaY != pizzaX);				//It is reflexive: for any non-null reference value x, x.equals(x) should return true. 		assertTrue("It is reflexive: for any non-null reference value x, x.equals(x) should return true. ", pizzaY.equals(pizzaY));				//It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.  		assertTrue("It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true. ", pizzaX.equals(pizzaY) == pizzaY.equals(pizzaX));					//It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.   		assertTrue("It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true. ", (pizzaX.equals(pizzaY) && pizzaY.equals(pizzaZ)) ? pizzaX.equals(pizzaZ): false);					//Equals		assertTrue(pizzaY.getClass() + " equals arbeitet bei gleichen Objekten richtig ", pizzaY.equals(pizzaX));				pizzaZ.setPreis(8.50f);		assertFalse(pizzaZ.getClass() + " equals arbeitet bei ungleichen Objekten richtig ", pizzaZ.equals(pizzaX));				assertFalse(pizzaZ.getClass() + " equals arbeitet bei falschen Objekten (Nicht-" + pizzaZ.getClass() + " richtig ", pizzaZ.equals(new PizzaVO()));	}		@Test	public void equalsHashCodeInPizzaVO() {		pizzaX = new PizzaVO("Marghrita",new String [] {"Tomaten","K�se","Basilikum"},8.0f);		pizzaY = new PizzaVO("Marghrita",new String [] {"Tomaten","K�se","Basilikum"},8.0f);		//Gleiche Objekte liefern den gleichen HashCode  		assertTrue("Gleiche Objekte liefern den gleichen HashCode", pizzaX.equals(pizzaY) == ( pizzaX.hashCode() == pizzaY.hashCode()));		}}