package br.unicamp.ic.inf319;

/**
 * <img src="./doc-files/Part.png" alt="Part">
 *
 * @author INF319
 */
public abstract class Part {

	private String description;
	private final PartNumber partNumber;

	/**
	 *
	 * @param thePartNumber
	 * @param theDescription
	 */
	public Part(PartNumber thePartNumber, String theDescription) {
		description = theDescription;
		partNumber = thePartNumber;
	}

	/**
	 *
	 * @return double
	 */
	public abstract double cost();

	/**
	 * Este método existe para que seja possível exibir a lista de materiais
	 * conforme o exercício
	 */
	public abstract String list();

	/**
	 *
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Altera a descrição da parte
	 * @param desc
	 */
	public void setDescription(String desc) {
		description = desc;
	}

	/**
	 *
	 * @return PartNumber
	 */
	public PartNumber getPartNumber() {
		return partNumber;
	}
}
