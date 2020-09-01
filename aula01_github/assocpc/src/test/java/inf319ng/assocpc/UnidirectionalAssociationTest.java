package inf319ng.assocpc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnidirectionalAssociationTest {

	Pessoa p;
	Companhia c;
	
	@Before
	public void setUp() throws Exception {
		
	   p = new Pessoa();
	   c = new Companhia();
	}

	@Test
	public void test() {
	    p.econtratado(c,1000.0);
	    assertEquals(p.getSalario(), 1000.0, 0.0);
	    assertEquals(p.getCompanhia(), c);
	}

}