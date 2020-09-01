package inf319ng.assocattr;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.AfterClass;

import org.junit.Test;

public class AssociationAttributeTest {
	
	private static Companhia cb, ca, cc;
	private static Pessoa pa, pb, pc;
	
	@BeforeClass
	public static void testSetup() {
		ca = new Companhia("CA");
		cb = new Companhia("CB");
		cc = new Companhia("CC");
		pa = new Pessoa("NA", "SA");
		pb = new Pessoa("NB", "SB");
		pc = new Pessoa("NC", "SC");
	}

	@Test
	public void test() {
		assertEquals(ca.getNome(), "CA");
		assertEquals(cb.getNome(), "CB");
		assertEquals(cc.getNome(), "CC");
		assertEquals(pa.getEmprego(), null);
		
		ca.emprega(pa, 10000.00);
		ca.emprega(pb, 5000.00);
		
		cb.emprega(pa, 1000.0);
		cb.emprega(pb, 12000.0);
		
		assertEquals(ca.custoTotal(), 15000.0, 0.0);
        assertEquals(cb.custoTotal(), 13000.0, 0.0);
		cb.demite(pa);
        assertEquals(cb.custoTotal(), 12000.0, 0.0);
        cb.demite(pb);
        assertEquals(cb.custoTotal(), 0.0, 0.0);
        cc.emprega(pa, 2000.00);

        cc.emprega(pc, 2000.00);
        assertEquals(cc.custoTotal(), 4000.00, 0.0);
	}
	
	@AfterClass
	public static void testTearDown() {
		ca = null;
		cb = null;
		cc = null;
		pa = null;
		pb = null;
		pc = null;
	}

}
