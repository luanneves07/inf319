package inf319ng.assocobj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContratosDeTrabalho {
	private Map<Pessoa, HashSet<Contrato>> contratosEmpregados;
	private Map<Companhia, HashSet<Contrato>> contratosEmpregadores;

	public ContratosDeTrabalho() {
		contratosEmpregados = new HashMap<>();
		contratosEmpregadores = new HashMap<>();
	}

	public Map<Pessoa, HashSet<Contrato>> getContratosEmpregados() {
		return contratosEmpregados;
	}

	public Map<Companhia, HashSet<Contrato>> getContratosEmpregadores() {
		return contratosEmpregadores;
	}

	public void emprega(Companhia companhia, Pessoa pessoa, double salario) {
		Contrato contrato = new Contrato(companhia, pessoa, salario);

		contratosEmpregadores.putIfAbsent(companhia, new HashSet<>());
		contratosEmpregadores.get(companhia).add(contrato);
		contratosEmpregados.putIfAbsent(pessoa, new HashSet<>());
		contratosEmpregados.get(pessoa).add(contrato);
	}

	public void demite(Companhia companhia, Pessoa pessoa) {
		Contrato contratoFinalizado = contratosEmpregadores.get(companhia).stream()
				.filter(t -> t.getPessoa().equals(pessoa)).findFirst().orElse(new Contrato(null, null, -1.0f));
		contratosEmpregadores.get(companhia).remove(contratoFinalizado);
		contratosEmpregados.get(pessoa).remove(contratoFinalizado);
	}

}
