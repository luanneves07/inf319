# Lista de materiais

A modificação feita no sistema foi agrupada nas implementações das relações (Assembly e PiecePart);

No momento, cada classe é responsável por realizar o display de seus materiais formatado de uma
única maneira.
A classe Assembly que possui a lsita de componentes agora é dona de um método chamado list() que não recebe parâmetros.
Este método por sua vez é responsável por realizar o display da lista de materiais. Através de um índice que pode crescer de
maneira indefinida, é utilizado a feature de recursividade de forma que este índice sirva como ferramenta para identificar
a posição inicial em que o texto deve ser disponibilizado no console.
A classe PiecePart possui um método semelhante, entretanto como não possui uma lista de materiais não é necessário utilizar
uma recursão aqui.

Esta implementação pode ser melhorada desacoplando o código de escrita no console e criando
um único componente responsável por isto. A complexidade aumentaria um pouco, entretanto o reúso fica mais fácil.