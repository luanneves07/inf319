package inf319ng.assocpc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssocPCTest {
	
	private static Companhia ca, cb, cc;
	private static Pessoa pa, pb, pc;

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
		// Nesse caso nenhuma ação é necessária.
	}

	@Test
	public void test() {
		assertEquals(ca.getNome(), "CA");
		// A demissão de um empregado de uma empresa recém criada (0 empregados)
		// não deve gerar exceções.
		assertEquals(ca.getNumeroEmpregados(), 0);
        ca.demite();
        assertEquals(ca.getNumeroEmpregados(), 0);
        
		pa.econtratado(ca, 10000.0);
        assertEquals(ca.getNumeroEmpregados(), 1);
        pb.econtratado(ca, 10000.0);
        assertEquals(ca.getNumeroEmpregados(), 2);
        pc.econtratado(cb, 10000.0);
        assertEquals(cb.getNumeroEmpregados(), 1);
        assertEquals(ca.getNumeroEmpregados(), 2);
        
        assertEquals(pa.getCompanhia(), ca);
        assertEquals(pb.getCompanhia(), ca);
        assertEquals(pc.getCompanhia(), cb);
        
        pc.demitese();
        assertEquals(pc.getCompanhia(), null);
        assertEquals(pc.getSalario(), 0.0, 0.0);
        
        pc.econtratado(ca, 11000.0);
        assertEquals(pc.getSalario(), 11000.00, 0.0);
        
	}

}
