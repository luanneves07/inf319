package inf319ng.assocobj;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssocObjTest {
	
	private static ContratosDeTrabalho ct;
	private static Companhia cb, ca, cc;
	private static Pessoa pa, pb, pc;

	@Before
	public void setUp() throws Exception {
		ct = null;
		ca = null; cb = null; cc = null;
        pa = null; pb = null; pc = null;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
        ct = new ContratosDeTrabalho();
		ca = new Companhia("CA");
		cb = new Companhia("CB");
		cc = new Companhia("CC");
		pa = new Pessoa("NA", "SA");
		pb = new Pessoa("NB", "SB");
        pc = new Pessoa("NC", "SC");
		
		ca.setContratos(ct);
		cb.setContratos(ct);
		cc.setContratos(ct);
		pa.setContratos(ct);
		pb.setContratos(ct);
		pc.setContratos(ct);
	
		ca.emprega(pa, 10000.00);
		ca.emprega(pb, 5000.00);
		
		cb.emprega(pa, 1000.0);
		cb.emprega(pb, 12000.0);
		
		assertEquals(ca.custoTotal(), 15000.0, 0.0);
        assertEquals(cb.custoTotal(), 13000.0, 0.0);
		cb.demite(pa);
		assertNotNull(pa);
        assertEquals(cb.custoTotal(), 12000.0, 0.0);
        cb.demite(pb);
        assertEquals(cb.custoTotal(), 0.0, 0.0);
        cc.emprega(pa, 2000.00);

        cc.emprega(pc, 2000.00);
        assertEquals(cc.custoTotal(), 4000.00, 0.0);
	}

}
