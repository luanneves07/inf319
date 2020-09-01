package inf319ng.assocpc;

/**
 * 
 * @author Luiz Eduardo Buzato
 * <p>Associação entre Pessoa e Companhia</p>
 * <p>Sentido: Pessoa para Companhia</p><br>
 * <p>Cardinalidade: 0 ou 1</p>
 * <p>Uma Pessoa se associa a uma Companhia ao executar o método <b>econtratado</b></p><br>
 * <p>Uma Pessoa se desassocia de uma Companhia ao executar o método <b>demitese</b></p>
 */

public class Pessoa {
	
	private String nome;
	private String sobrenome;
    private Companhia empresa;
    private double salario;

    public Pessoa() {
    	nome = "";
    	sobrenome = "";
        empresa = null;
        salario = 0.0;
    }
    
    public Pessoa(String nome, String sobrenome) {
    	this.nome = nome;
    	this.sobrenome = sobrenome;
    	this.empresa = null;
    	this.salario = 0.0;    	
    }
    
    
    public Pessoa(String nome, String sobrenome, Companhia emprego, double salario) {
    	this.nome = nome;
    	this.sobrenome = sobrenome;
    	this.empresa = emprego;
    	this.salario = salario;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public String getSobrenome() {
    	return sobrenome;
    }
    
    public Companhia getCompanhia() {
        return empresa;
    }
    
    public double getSalario() {
        return salario;
    }

    /**
     * <p> O método <b>econtratado</b> estabelece a associação entre uma <b>Pessoa</b> e uma <b>Companhia</b>.</p>
     * 
     * @param empresa: nome da empresa onde a Pessoa se contratou.
     * @param salario: salario da Pessoa.
     */
    public void econtratado(Companhia empresa, double salario) {
        this.empresa = empresa;
        empresa.contrata();
        this.salario = salario;
        
    }
    /**
     * <p>O método <b>demitese</b> remove a associação entre uma <b>Pessoa</b> e uma <b>Companhia</b>. </p>
     * 
     * <p>O método <b>demitese</b> garante que o salário é zerado e que o relacionamento entre a Pessoa e a Empresa é removido.</p>
     */
    public void demitese() {
        salario = 0.0;
        empresa.demite();
        empresa = null;
    }
}
