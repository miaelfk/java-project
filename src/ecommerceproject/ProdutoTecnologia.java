package ecommerceproject;

public class ProdutoTecnologia extends Produto {
    private String especificacaoTecnica;

    public ProdutoTecnologia(String nome, double preco, String especificacaoTecnica) {
        super(nome, preco);
        this.especificacaoTecnica = especificacaoTecnica;
    }

    public String getEspecificacaoTecnica() {
        return especificacaoTecnica;
    }

    public void setEspecificacaoTecnica(String especificacaoTecnica) {
        this.especificacaoTecnica = especificacaoTecnica;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Especificação Técnica: " + especificacaoTecnica);
    }
}

