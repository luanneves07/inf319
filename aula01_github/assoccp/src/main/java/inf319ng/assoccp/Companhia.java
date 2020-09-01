package inf319ng.assoccp;

import java.util.ArrayList;
import java.util.List;

public class Companhia {

	private String nome_empresa;
	private List<Pessoa> empregados;

	public Companhia() {
		this("");
	}

	public Companhia(String nome_empresa) {
		super();
		this.nome_empresa = nome_empresa;
		this.empregados = new ArrayList<>();
	}

	public String getNome() {
		return nome_empresa;
	}

	public void emprega(Pessoa pessoa, double salario) {
		pessoa.setSalario(salario);
		empregados.add(new Pessoa(pessoa.getNome(), pessoa.getSobreNome(), pessoa.getSalario()));
	}

	public void demite(Pessoa pessoa) {
		pessoa.setSalario(0.0f);
		empregados.remove(pessoa);
	}

	public double custoTotal() {
		return empregados.stream().mapToDouble(p -> p.getSalario()).sum();
	}
}
