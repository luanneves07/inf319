package inf319ng.assocpc;

/**
 * 
 * @author Luiz Eduardo Buzato
 * 
 * Companhia
 * <p>
 * Não mantém associação com nenhuma classe.
 * @see Pessoa
 * 
 */

public class Companhia {

	// 
	private String nome_companhia;
    // contra
	private int contratos;
	
	public Companhia() {
		nome_companhia = "";
		contratos = 0;
	}
	
	public Companhia(String nome_companhia) {
		this.nome_companhia = nome_companhia;
	}
	
	public String getNome() {
		return nome_companhia;
	}
	
	public int getNumeroEmpregados() {
		return contratos;
	}
	
	public void contrata() {
		contratos++;
	}
	
	public void demite() {
		if (contratos > 0) contratos--;
	}
	
}
