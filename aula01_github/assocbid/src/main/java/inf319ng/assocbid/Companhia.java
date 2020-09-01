package inf319ng.assocbid;

import java.util.HashSet;
import java.util.Set;

public class Companhia {

	private String nome_empresa;
	private Set<Pessoa> empregados;

	public Companhia() {
		this("");
	}

	public Companhia(String nome_empresa) {
		super();
		this.nome_empresa = nome_empresa;
		this.empregados = new HashSet<>();
	}

	public String getNome() {
		return nome_empresa;
	}

	public void emprega(Pessoa pessoa, double salario) {
		pessoa.emprega(this, salario);
		empregados.add(pessoa);
	}

	public void demite(Pessoa pessoa) {
		pessoa.demite();
		empregados.remove(pessoa);
	}

	public double custoTotal() {
		return empregados.stream().mapToDouble(p -> p.getSalario()).sum();
	}
}
