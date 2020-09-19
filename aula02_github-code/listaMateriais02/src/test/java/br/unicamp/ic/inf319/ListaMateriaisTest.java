package br.unicamp.ic.inf319;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class ListaMateriaisTest extends TestCase {

	public void testPart() {
		PartNumber number = new PartNumber(42);
		Part part = new PiecePart(number, "description", 23);
		assertEquals(42, part.getPartNumber().getNumber());
		assertEquals("description", part.getDescription());
		part.setDescription("new description");
		assertEquals("new description", part.getDescription());
	}

	public void testPiecePart() {
		PartNumber number = new PartNumber(42);
		PiecePart part = new PiecePart(number, "description", 23);
		assertEquals(23, part.cost(), 0);
		part.setCost(5);
		assertEquals(5, part.cost(), 0);
	}

	public void testAssembly() {
		PartNumber number1 = new PartNumber(23);
		PartNumber number2 = new PartNumber(42);
		PartNumber number3 = new PartNumber(69);

		Assembly assembly1 = new Assembly(number1, "assembly1");
		Assembly assembly2 = new Assembly(number2, "assembly2");
		Assembly assembly3 = new Assembly(number3, "assembly3");

		for (int i = 0; i < 10; i++) {
			assembly1.addPart(new PiecePart(new PartNumber(i), "pp" + i, i));
		}
		assertEquals(((9 + 0) * 10) / 2, assembly1.cost(), 0);

		for (int i = 10; i < 20; i++) {
			assembly2.addPart(new PiecePart(new PartNumber(i), "pp" + i, i));
		}
		assertEquals(((19 + 10) * 10) / 2, assembly2.cost(), 0);

		assembly3.addPart(assembly1);
		assembly3.addPart(assembly2);
		assertEquals(assembly1.cost() + assembly2.cost(), assembly3.cost(), 0);

		double cost = assembly3.cost();
		assembly2.addPart(new PiecePart(new PartNumber(75), "piece", 10));
		assertEquals(cost + 10, assembly3.cost(), 0);
	}

	public void testList() {

		// Átomos para a roda dianteira
		PiecePart aroDianteiro = new PiecePart(new PartNumber(51), "Aro Dianteiro", 20.0);
		PiecePart cuboDianteiro = new PiecePart(new PartNumber(52), "Cubo Dianteiro", 30.0);
		PiecePart raiosDianteiro = new PiecePart(new PartNumber(53), "Raios Dianteiro", 5.0);
		PiecePart pneuDianteiro = new PiecePart(new PartNumber(54), "Pneu Dianteiro", 15.0);

		// Roda dianteira
		Assembly rodaDianteira = new Assembly(new PartNumber(5), "Roda Dianteira");
		rodaDianteira.addPart(aroDianteiro);
		rodaDianteira.addPart(cuboDianteiro);
		rodaDianteira.addPart(raiosDianteiro);
		rodaDianteira.addPart(pneuDianteiro);

		// Átomos para a roda traseira
		PiecePart aroTraseiro = new PiecePart(new PartNumber(61), "Aro Traseiro", 20.0);
		PiecePart cuboTraseiro = new PiecePart(new PartNumber(62), "Cubo Traseiro", 30.0);
		PiecePart raiosTraseiro = new PiecePart(new PartNumber(63), "Raios Traseiro", 5.0);
		PiecePart pneuTraseiro = new PiecePart(new PartNumber(64), "Pneu Traseiro", 15.0);

		// Roda Traseira
		Assembly rodaTraseira = new Assembly(new PartNumber(6), "Roda Traseira");
		rodaTraseira.addPart(aroTraseiro);
		rodaTraseira.addPart(cuboTraseiro);
		rodaTraseira.addPart(raiosTraseiro);
		rodaTraseira.addPart(pneuTraseiro);

		Assembly motocicleta = new Assembly(new PartNumber(7), "Motocicleta");
		motocicleta.addPart(rodaDianteira);
		motocicleta.addPart(rodaTraseira);

		assertEquals(140.0, motocicleta.cost());

	}

	public void testIfListIsCorrect() {
		// Átomos para a roda dianteira
		PiecePart aroDianteiro = new PiecePart(new PartNumber(51), "Aro Dianteiro", 20.0);
		PiecePart cuboDianteiro = new PiecePart(new PartNumber(52), "Cubo Dianteiro", 30.0);
		PiecePart raiosDianteiro = new PiecePart(new PartNumber(53), "Raios Dianteiro", 5.0);
		PiecePart pneuDianteiro = new PiecePart(new PartNumber(54), "Pneu Dianteiro", 15.0);

		// Roda dianteira
		Assembly rodaDianteira = new Assembly(new PartNumber(5), "Roda Dianteira");
		rodaDianteira.addPart(aroDianteiro);
		rodaDianteira.addPart(cuboDianteiro);
		rodaDianteira.addPart(raiosDianteiro);
		rodaDianteira.addPart(pneuDianteiro);

		// Átomos para a roda traseira
		PiecePart aroTraseiro = new PiecePart(new PartNumber(61), "Aro Traseiro", 20.0);
		PiecePart cuboTraseiro = new PiecePart(new PartNumber(62), "Cubo Traseiro", 30.0);
		PiecePart raiosTraseiro = new PiecePart(new PartNumber(63), "Raios Traseiro", 5.0);
		PiecePart pneuTraseiro = new PiecePart(new PartNumber(64), "Pneu Traseiro", 15.0);

		// Roda Traseira
		Assembly rodaTraseira = new Assembly(new PartNumber(6), "Roda Traseira");
		rodaTraseira.addPart(aroTraseiro);
		rodaTraseira.addPart(cuboTraseiro);
		rodaTraseira.addPart(raiosTraseiro);
		rodaTraseira.addPart(pneuTraseiro);

		Assembly p = new Assembly(new PartNumber(55), "pp");
		Assembly a = new Assembly(new PartNumber(56), "aa");
		Assembly b = new Assembly(new PartNumber(57), "bb");
		Assembly c = new Assembly(new PartNumber(58), "cc");
		p.addPart(a);
		a.addPart(b);
		b.addPart(c);
		c.addPart(aroDianteiro);
		c.addPart(cuboDianteiro);
		c.addPart(raiosDianteiro);

		rodaTraseira.addPart(p);

		Assembly motocicleta = new Assembly(new PartNumber(7), "Motocicleta");
		motocicleta.addPart(rodaDianteira);
		motocicleta.addPart(rodaTraseira);

		Set<Part> parts = new HashSet<>(Arrays.asList(a));
		
		assertEquals(parts, p.getParts());
		assertEquals(getBOMTestModel(), motocicleta.list());
		assertEquals("Parte: 61; Descricao: Aro Traseiro; Custo: 20.0\n", aroTraseiro.list());
	}

	private String getBOMTestModel() {
		StringBuilder model = new StringBuilder();

		model.append("Parte: 7; Descricao: Motocicleta; Custo: 195.0\n");
		model.append(" Parte: 5; Descricao: Roda Dianteira; Custo: 70.0\n");
		model.append("  Parte: 51; Descricao: Aro Dianteiro; Custo: 20.0\n");
		model.append("  Parte: 52; Descricao: Cubo Dianteiro; Custo: 30.0\n");
		model.append("  Parte: 53; Descricao: Raios Dianteiro; Custo: 5.0\n");
		model.append("  Parte: 54; Descricao: Pneu Dianteiro; Custo: 15.0\n");
		model.append(" Parte: 6; Descricao: Roda Traseira; Custo: 125.0\n");
		model.append("  Parte: 55; Descricao: pp; Custo: 55.0\n");
		model.append("   Parte: 56; Descricao: aa; Custo: 55.0\n");
		model.append("    Parte: 57; Descricao: bb; Custo: 55.0\n");
		model.append("     Parte: 58; Descricao: cc; Custo: 55.0\n");
		model.append("      Parte: 51; Descricao: Aro Dianteiro; Custo: 20.0\n");
		model.append("      Parte: 52; Descricao: Cubo Dianteiro; Custo: 30.0\n");
		model.append("      Parte: 53; Descricao: Raios Dianteiro; Custo: 5.0\n");
		model.append("  Parte: 61; Descricao: Aro Traseiro; Custo: 20.0\n");
		model.append("  Parte: 62; Descricao: Cubo Traseiro; Custo: 30.0\n");
		model.append("  Parte: 63; Descricao: Raios Traseiro; Custo: 5.0\n");
		model.append("  Parte: 64; Descricao: Pneu Traseiro; Custo: 15.0\n");

		return model.toString();
	}

}
