package ecommerceproject;

import ecommerceproject.utils.Cores;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class menuprincipal {
    private static List<Produto> produtos = new ArrayList<>();
    private static HashMap<Produto, Integer> estoque = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
   
            System.out.println(Cores.YELLOW_PASTEL + "\n═══════════════════════════════" + Cores.RESET);
            System.out.println(Cores.WHITE_BOLD + "           GEEKSHOP           " + Cores.RESET);
            System.out.println(Cores.YELLOW_PASTEL + "═══════════════════════════════" + Cores.RESET);
            
    
            System.out.println(Cores.BLUE_PASTEL + "\n1. " + Cores.RESET + "Cadastrar novo produto");
            System.out.println(Cores.BLUE_PASTEL + "2. " + Cores.RESET + "Listar produtos cadastrados");
            System.out.println(Cores.BLUE_PASTEL + "3. " + Cores.RESET + "Adicionar ao estoque");
            System.out.println(Cores.BLUE_PASTEL + "4. " + Cores.RESET + "Remover do estoque");
            System.out.println(Cores.BLUE_PASTEL + "5. " + Cores.RESET + "Visualizar estoque");
            System.out.println(Cores.LIGHT_PINK + "6. " + Cores.RESET + "Sair do sistema");
            System.out.println("");
            System.out.println(Cores.YELLOW_PASTEL + "═══════════════════════════════" + Cores.RESET);

            System.out.print(Cores.ITALIC + "\n➤ Digite sua escolha: " + Cores.RESET);
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(Cores.YELLOW_PASTEL + "\n═════════ NOVO PRODUTO ═════════" + Cores.RESET);
                    System.out.println("");
                    System.out.print(Cores.WHITE_BOLD + "Tipo (1-Colecionável 2-Vestuário 3-Decoração 4-Tecnologia 5-Livro): " + Cores.RESET);
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print(Cores.WHITE_BOLD + "\nNome do produto: " + Cores.RESET);
                    String nome = scanner.nextLine();

                    System.out.print(Cores.WHITE_BOLD + "Preço: R$" + Cores.RESET);
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    Produto produto = criarProduto(tipo, nome, preco, scanner);
                    if (produto != null) {
                        produtos.add(produto);
                        System.out.println(Cores.YELLOW_PASTEL + "\n✔ Produto cadastrado com sucesso!" + Cores.RESET);
                    }
                    break;

                case 2:
                    System.out.println(Cores.YELLOW_PASTEL + "\n══════ CATÁLOGO ══════" + Cores.RESET);
                    if (produtos.isEmpty()) {
                        System.out.println(Cores.LIGHT_PINK + "\nNenhum produto cadastrado" + Cores.RESET);
                    } else {
                        produtos.forEach(p -> {
                            System.out.println(Cores.BLUE_PASTEL + "➤ " + p.getNome() + Cores.RESET);
                            p.exibirDetalhes();
                            System.out.println(Cores.YELLOW_PASTEL + "――――――――――――――――――――――――――" + Cores.RESET);
                        });
                    }
                    break;

                case 3:
                    System.out.println(Cores.YELLOW_PASTEL + "\n══════ GERENCIAR ESTOQUE ══════" + Cores.RESET);
                    System.out.print(Cores.WHITE_BOLD + "Nome do produto: " + Cores.RESET);
                    String nomeProduto = scanner.nextLine();

                    Produto produtoEstoque = buscarProduto(nomeProduto);
                    if (produtoEstoque != null) {
                        System.out.print(Cores.WHITE_BOLD + "Quantidade: " + Cores.RESET);
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();

                        estoque.put(produtoEstoque, quantidade);
                        System.out.println(Cores.YELLOW_PASTEL + "\n✔ Estoque atualizado!" + Cores.RESET);
                    } else {
                        System.out.println(Cores.LIGHT_PINK + "\nProduto não encontrado!" + Cores.RESET);
                    }
                    break;
                    
                case 4:
                    System.out.println(Cores.YELLOW_PASTEL + "\n══════ REMOVER DO ESTOQUE ══════" + Cores.RESET);
                    System.out.print(Cores.WHITE_BOLD + "Nome do produto: " + Cores.RESET);
                    String nomeProdutoRemover = scanner.nextLine();

                    Produto produtoRemover = buscarProduto(nomeProdutoRemover);
                    
                    if (produtoRemover != null) {
                        System.out.print(Cores.WHITE_BOLD + "Quantidade a remover: " + Cores.RESET);
                        int quantidadeRemover = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            int estoqueAtual = estoque.getOrDefault(produtoRemover, 0);
                            
                            if (quantidadeRemover > estoqueAtual) {
                                throw new EstoqueInsuficienteException("Quantidade insuficiente em estoque!");
                            }
                            
                            estoque.put(produtoRemover, estoqueAtual - quantidadeRemover);
                            System.out.println(Cores.YELLOW_PASTEL + "\n✔ Quantidade removida com sucesso!" + Cores.RESET);
                        
                        } catch (EstoqueInsuficienteException e) {
                            System.out.println(Cores.LIGHT_PINK + "\nErro: " + e.getMessage() + Cores.RESET);
                        }
                    
                    } else {
                        System.out.println(Cores.LIGHT_PINK + "\nProduto não encontrado!" + Cores.RESET);
                    }
                    break;

                case 5:
                    System.out.println(Cores.YELLOW_PASTEL + "\n══════ ESTOQUE ATUAL ══════" + Cores.RESET);
                    if (estoque.isEmpty()) {
                        System.out.println(Cores.LIGHT_PINK + "\nEstoque vazio" + Cores.RESET);
                    } else {
                        estoque.forEach((prod, qtd) -> {
                            System.out.println(Cores.BLUE_PASTEL + "➤ " + prod.getNome() + Cores.RESET);
                            System.out.println("Quantidade: " + Cores.YELLOW_PASTEL + qtd + Cores.RESET);
                            System.out.println(Cores.YELLOW_PASTEL + "――――――――――――――――――――――――――――" + Cores.RESET);
                        });
                    }
                    break;

                case 6:
                    executando = false;
                    System.out.println(Cores.YELLOW_PASTEL + "\n══════════ ATÉ LOGO! ══════════" + Cores.RESET);
                    System.out.println("");
                    System.out.println(Cores.ITALIC + " Sistema encerrado com sucesso." + Cores.RESET);
                    System.out.println("");
                    System.out.println(Cores.ITALIC + "    A GeekShop agradece! ツ" + Cores.RESET);
                    break;

                default:
                    System.out.println(Cores.LIGHT_PINK + "\n⚠ Opção inválida!" + Cores.RESET);
            }
        }
        scanner.close();
    }

    private static Produto criarProduto(int tipo, String nome, double preco, Scanner scanner) {
        Produto produto = null;

        if (tipo == 1) {
            System.out.print(Cores.WHITE_BOLD + "Franquia (ex: Star Wars): " + Cores.RESET);
            String franquia = scanner.nextLine();
            produto = new ProdutoColecionaveis(nome, preco, franquia);

        } else if (tipo == 2) {
            System.out.print(Cores.WHITE_BOLD + "Tamanho (ex: M): " + Cores.RESET);
            String tamanho = scanner.nextLine();
            produto = new ProdutoVestuario(nome, preco, tamanho);

        } else if (tipo == 3) {
            System.out.print(Cores.WHITE_BOLD + "Material (ex: Madeira): " + Cores.RESET);
            String material = scanner.nextLine();
            produto = new ProdutoDecoracao(nome, preco, material);

        } else if (tipo == 4) { 
            System.out.print(Cores.WHITE_BOLD + "Especificação Técnica (ex: Teclado Mecânico RGB): " + Cores.RESET);
            String especificacao = scanner.nextLine();
            produto = new ProdutoTecnologia(nome, preco, especificacao);

        } else if (tipo == 5) { 
            System.out.print(Cores.WHITE_BOLD + "Autor (ex: J.K. Rowling): " + Cores.RESET);
            String autor = scanner.nextLine();
            produto = new ProdutoLiteratura(nome, preco, autor);

        } else {
            System.out.println(Cores.LIGHT_PINK + "\n⚠ Tipo inválido!" + Cores.RESET);
        }

        return produto;
    }

    private static Produto buscarProduto(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}
