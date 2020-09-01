package inf319ng.assocattr;

import java.util.HashMap;
import java.util.Map;

public class Companhia {

	private String nome_empresa;
	private Map<Pessoa, Contrato> contratosTrabalho;

	public Companhia() {
		this("");
	}

	public Companhia(String nome_empresa) {
		super();
		this.nome_empresa = nome_empresa;
		this.contratosTrabalho = new HashMap<>();
	}

	public String getNome() {
		return nome_empresa;
	}

	public void emprega(final Pessoa pessoa, double salario) {
		Pessoa colaborador = new Pessoa(pessoa.getNome(), pessoa.getSobreNome());
		Contrato contrato = new Contrato(this, colaborador, salario);
		colaborador.emprega(contrato);
		contratosTrabalho.put(colaborador, contrato);
	}

	public void demite(Pessoa pessoa) {
		contratosTrabalho.remove(pessoa);
		pessoa.demite();
	}

	public double custoTotal() {
		return contratosTrabalho.keySet().stream().mapToDouble(p -> p.getSalario()).sum();
	}
}
