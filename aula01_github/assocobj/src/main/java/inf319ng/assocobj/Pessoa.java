package inf319ng.assocobj;

import java.util.Set;

public class Pessoa {
	private String nome;
	private String sobreNome;

	private ContratosDeTrabalho contratos;

	public Pessoa(String nome, String sobreNome) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.contratos = new ContratosDeTrabalho();
	}

	public void setContratos(ContratosDeTrabalho contratos) {
		this.contratos = contratos;
	}

	public ContratosDeTrabalho getContratos() {
		return contratos;
	}

	public String getName() {
		return nome;
	}

	public Set<Companhia> getEmpregos() {
		return contratos.getContratosEmpregadores().keySet();
	}

	public double getSalarioTotal() {
		return contratos.getContratosEmpregados().get(this).stream().mapToDouble(p -> p.getSalario()).sum();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobreNome == null) ? 0 : sobreNome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobreNome == null) {
			if (other.sobreNome != null)
				return false;
		} else if (!sobreNome.equals(other.sobreNome))
			return false;
		return true;
	}
}
