Neste modelo, a classe Contrato não sofreu alteração. Apenas o uso dela foi delegado.
Por outro lado, as classes Pessoa e Companhia agora apenas delegam suas tarefas referentes ao contrato.

O modelamento abordado aqui é interessante e, de certa forma, acaba desacoplando o uso de Contrato um pouco mais que os outros modelos.
A distribuição de responsabilidades também fica mais clara neste código. Entretanto a complexidade é muito mais alta que o modelo BID.