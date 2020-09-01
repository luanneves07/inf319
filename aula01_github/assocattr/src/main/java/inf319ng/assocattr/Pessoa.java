package inf319ng.assocattr;

public class Pessoa {
	private String nome;
	private String sobreNome;

	private Contrato contratoTrabalho;

	public Pessoa() {
		this("", "");
	}

	public Pessoa(String nome, String sobreNome) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.contratoTrabalho = new Contrato(null, this, 0.0f);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public Companhia getEmprego() {
		return contratoTrabalho.getEmpregador();
	}

	public double getSalario() {
		return contratoTrabalho.getSalario();
	}

	public void emprega(Contrato contrato) {
		this.contratoTrabalho = contrato;
	}

	public void demite() {
		contratoTrabalho = null;
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
