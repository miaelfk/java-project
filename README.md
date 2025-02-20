# GeekShop - E-commerce Geek

GeekShop é um sistema de e-commerce voltado para produtos geek. Este projeto foi desenvolvido em Java, utilizando conceitos de Programação Orientada a Objetos (POO), Collections e Exceptions.

---

## **Funcionalidades Implementadas**

### **Etapa 1: Menu Interativo**
- Menu estilizado com cores e opções numeradas.
- Cadastro de produtos por categoria.
- Listagem detalhada de produtos cadastrados.

### **Etapa 2: Programação Orientada a Objetos (POO)**
- Classe abstrata `Produto` com atributos comuns (`nome` e `preco`).
- Subclasses específicas, como:
  - `ProdutoColecionavel`
  - `ProdutoVestuarioGeek`
  - `ProdutoDecoracaoGeek`
  - `ProdutoTecnologia`
  - `ProdutoLiteraturaGeek`
- Polimorfismo implementado no método `exibirDetalhes()`.

### **Etapa 3: Collections e Exceptions**
- Gerenciamento de estoque utilizando `HashMap`:
  - Adicionar estoque.
  - Remover estoque com validação.
  - Visualizar estoque atual.
- Exceções personalizadas:
  - Classe `EstoqueInsuficienteException` para tratar remoção de quantidade maior que o disponível.
