package br.unicamp.ic.inf319;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <img src="./doc-files/Assembly.png" alt="Assembly">
 *
 * @author INF319
 */
public class Assembly extends Part {

	private final Set<Part> parts;

	/**
	 * Construtor padrão para o objeto que é composto por outros objetos compondo o
	 * componente
	 * 
	 * @param thePartNumber  o código da peça
	 * @param theDescription descriçào da peça
	 */
	public Assembly(PartNumber thePartNumber, String theDescription) {
		super(thePartNumber, theDescription);
		parts = new HashSet<>();
	}

	/**
	 * itera em toda a lista de parts acumulando o valor total.
	 * 
	 * @return
	 */
	@Override
	public double cost() {
		double totalCost = 0;
		// 1 - for opção
		// for (Iterator<Part> i = parts.iterator(); i.hasNext();) {
		// Part part = (Part) i.next();
		// totalCost += part.cost();
		// }
		// 2 - for-loop
		// for (Part part : parts) {
		// totalCost += part.cost();
		// }
		// 3 - Can use functional operations
		totalCost = parts.stream().map(part -> part.cost()).reduce(totalCost,
				(accumulator, _item) -> accumulator + _item);
		return totalCost;
	}

	/**
	 * Adiciona uma nova parte a peça de montagem
	 * 
	 * @param thePart
	 */
	public void addPart(Part thePart) {
		parts.add(thePart);
	}

	/**
	 * Permite recuperar e verificar as peças já adicionadas no componente.
	 * 
	 * @return
	 */
	public Set<Part> getParts() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 */
	public String list() {
		return list(0);
	}

	/**
	 * Este método utiliza um índice horizonatal da linha para identificar a posição
	 * em que a string de output deve ser inicializada na linha seguinte. Aqui foi
	 * utilizado um pouco de recursividade para auxiliar no cálculo da posição de
	 * cada início do texto de descrição das partes.
	 * 
	 * @param horizontalIndex
	 * @return String contendo uma lista dos materias separados por quebra de linha
	 *         e ordenados por código de peça
	 */
	private String list(int horizontalIndex) {
		StringBuilder listString = new StringBuilder();
		for (int i = 0; i < horizontalIndex; i++) {
			listString.append(" ");
		}

		listString.append(describe());

		parts.stream().sorted((o1, o2) -> o1.getPartNumber().getNumber() - o2.getPartNumber().getNumber())
				.map(t -> listString.append(t instanceof Assembly ? ((Assembly) t).list(horizontalIndex + 1)
						: ((PiecePart) t).list(horizontalIndex, " ")))
				.collect(Collectors.toSet());

		return listString.toString();
	}

	/**
	 * Este método foi criado para que fosse possível externalizar o ato de criar a
	 * String de exibição atribuida para este componente que possui menos campos.
	 * 
	 * @return Striong no formato "Parte: cod; Descricao: desc; Custo: custo\n" com
	 *         os dados referentes ao objeto atual
	 */
	private String describe() {
		return String.format(Locale.US, "Parte: %s; Descricao: %s; Custo: %,.1f%n", super.getPartNumber().getNumber(),
				super.getDescription(), cost());
	}
}
