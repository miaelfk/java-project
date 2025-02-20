package ecommerceproject;

public class ProdutoColecionaveis extends Produto {
    private String franquia;

    public ProdutoColecionaveis(String nome, double preco, String franquia) {
        super(nome, preco);
        this.franquia = franquia;
    }

    public String getFranquia() {
        return franquia;
    }

    public void setFranquia(String franquia) {
        this.franquia = franquia;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Franquia: " + franquia);
    }
}
