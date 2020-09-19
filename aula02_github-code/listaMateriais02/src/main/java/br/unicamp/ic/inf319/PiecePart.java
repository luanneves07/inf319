package br.unicamp.ic.inf319;

import java.util.Locale;

/**
 * <img src="./doc-files/PiecePart.png" alt="PiecePart">
 *
 * @author INF319
 */
public class PiecePart extends Part {

	private double cost;

	/**
	 *
	 * @param thePartNumber
	 * @param theDescription
	 * @param theCost
	 */
	public PiecePart(PartNumber thePartNumber, String theDescription, double theCost) {
		super(thePartNumber, theDescription);
		cost = theCost;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public double cost() {
		return cost;
	}

	/**
	 *
	 * @param c
	 */
	public void setCost(double c) {
		cost = c;
	}

	/**
	 * {@inheritDoc}
	 */
	public String list() {
		return list(0);
	}

	private String list(int horizontalIndex) {
		return list(horizontalIndex, "");
	}

	/**
	 * Este método é semelhante ao utilizado em {@linkplain Assembly}, entretanto
	 * possui a difereça de que o mesmo não possui uma nova lista para ser iterada.
	 * 
	 * @param horizontalIndex Índice inicial da String onde o dado deve ser escrito
	 * @param prefix          prefixo que pode variar de tamanho de acordo com o
	 *                        nível
	 * @return Lista formatada de acordo com o requisitado pelo exercício
	 */
	protected String list(int horizontalIndex, String prefix) {
		StringBuilder listString = new StringBuilder();
		for (int i = 0; i < horizontalIndex; i++) {
			listString.append(" ");
		}
		listString.append(String.format(Locale.US, "%sParte: %s; Descricao: %s; Custo: %,.1f%n", prefix,
				super.getPartNumber().getNumber(), super.getDescription(), cost()));

		return listString.toString();
	}
}
