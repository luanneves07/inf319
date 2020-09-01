package inf319ng.assocbid;

public class Pessoa {
	private String nome;
	private String sobreNome;
	private double salario;

	private Companhia emprego;

	public Pessoa() {
		this("", "");
	}

	public Pessoa(String nome, String sobreNome) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.salario = 0.0f;
		this.emprego = new Companhia();
	}

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public Companhia getEmprego() {
		return emprego;
	}

	public double getSalario() {
		return salario;
	}

	public void emprega(Companhia companhia, double salario) {
		this.emprego = companhia;
		this.salario = salario;
	}

	public void demite() {
		this.emprego = null;
		this.salario = 0.0f;
	}
}
