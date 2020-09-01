package inf319ng.assocobj;

public class Companhia {

	private String nome_empresa;
	private ContratosDeTrabalho contratos;

	public Companhia(String nome_empresa) {
		super();
		this.nome_empresa = nome_empresa;
		this.contratos = new ContratosDeTrabalho();
	}

	public String getNome() {
		return nome_empresa;
	}

	public void setContratos(ContratosDeTrabalho contratos) {
		this.contratos = contratos;
	}

	public ContratosDeTrabalho getContratos() {
		return contratos;
	}

	public void emprega(final Pessoa pessoa, double salario) {
		contratos.emprega(this, pessoa, salario);
	}

	public void demite(Pessoa pessoa) {
		contratos.demite(this, pessoa);
	}

	public double custoTotal() {
		return contratos.getContratosEmpregadores().get(this).stream().mapToDouble(p -> p.getSalario()).sum();
	}
}
