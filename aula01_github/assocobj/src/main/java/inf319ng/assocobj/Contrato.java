package inf319ng.assocobj;

public class Contrato {

	private double salario;
	private Pessoa empregado;
	private Companhia empregador;

	public Contrato(Companhia empregador, Pessoa empregado, double salario) {
		super();
		this.salario = salario;
		this.empregado = empregado;
		this.empregador = empregador;
	}

	public Companhia getEmpregador() {
		return empregador;
	}

	public Pessoa getPessoa() {
		return empregado;
	}

	public double getSalario() {
		return salario;
	}
}
