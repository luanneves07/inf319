package inf319ng.assocbid;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssocBidTest {
	
	Pessoa pa, pb, pc;
	Companhia ca, cb, cc;

	@Before
	public void setUp() throws Exception {
		
		ca = new Companhia("CA");
		cb = new Companhia("CB");
		cc = new Companhia("CC");
		pa = new Pessoa("NA", "SA");
		pb = new Pessoa("NB", "SB");
		pc = new Pessoa("NC", "SC");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		ca.emprega(pa, 10000.0);
		assertEquals(ca.custoTotal(), 10000.0, 0.0);
		
		
	}

}
