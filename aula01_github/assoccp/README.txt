- A diferença existente dentro desta implementação quando comparado ao arquivo AssocCP.jpg é basicamente a implementação dos métodos equals e hashcode dentro do objeto Pessoa.java.
Neste caso, isto foi feito para que fosse possível inserir um novo objeto na lista de empregados e, posteriormente, remover sem precisar da referência do mesmo dentro da lista.
Isto não interefe no modelo, apenas na implementação e manutenção do sistema.

- O relacionamento utilizado neste caso apenas proporciona uma visualização Companhia ~ Pessoa.
- Neste caso, um primeiro problema existente neste modelamento, é que seria um pouco complexo se um dia aparecer 
uma situação onde uma pessoa trabalha para mais de uma empresa.
