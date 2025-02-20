package ecommerceproject;

public class ProdutoVestuario extends Produto {
    private String tamanho;

    public ProdutoVestuario(String nome, double preco, String tamanho) {
        super(nome, preco); // Chama o construtor da classe Produto
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Tamanho: " + tamanho);
    }
}
