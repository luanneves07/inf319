package inf319ng.assocpc;

import junit.framework.TestCase;

public class AssocUnid1Test extends TestCase {
	
	public void testAssociation() {
		Pessoa Ana = new Pessoa();
		assertNull(Ana.getCompanhia());
		assertTrue(Ana.getSalario()==0);
		Pessoa Pedro = new Pessoa();
		assertNull(Pedro.getCompanhia());
		assertTrue(Ana.getSalario()==0);
		Companhia Gessy = new Companhia();
		Ana.econtratado(Gessy, 3500.0);
		assertEquals(Gessy,Ana.getCompanhia());
		assertEquals(Ana.getSalario(), 3500.0);
		Pedro.econtratado(Gessy, 2305.0);
		assertEquals(Pedro.getSalario(), 2305.0);
		assertEquals(Gessy,Pedro.getCompanhia());
		
	}

}
