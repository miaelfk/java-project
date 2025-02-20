package ecommerceproject;

public class ProdutoDecoracao extends Produto {
    private String tipoMaterial;

    public ProdutoDecoracao(String nome, double preco, String tipoMaterial) {
        super(nome, preco);
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Material: " + tipoMaterial);
    }
}

