package ecommerceproject;

import ecommerceproject.utils.Cores;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuprincipal {
    private static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println(Cores.YELLOW_PASTEL + "=========" + Cores.RESET + " " 
                + Cores.WHITE_BOLD + "GeekShop" + Cores.RESET + " " 
                + Cores.YELLOW_PASTEL + "=========" + Cores.RESET);
            System.out.println("");
            System.out.println(Cores.ITALIC + "    1." + Cores.RESET + " " + Cores.BLUE_PASTEL + "Cadastrar produto" + Cores.RESET);
            System.out.println(Cores.ITALIC + "    2." + Cores.RESET + " " + Cores.BLUE_PASTEL + "Listar produtos" + Cores.RESET);
            System.out.println(Cores.ITALIC + "    3." + Cores.RESET + " " + Cores.LIGHT_PINK + "Sair" + Cores.RESET);
            System.out.println(Cores.YELLOW_PASTEL + "\n============================" + Cores.RESET);

            System.out.print("\n" + Cores.WHITE_BOLD + "     Escolha uma opção: " + Cores.RESET);

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
            case 1:
                System.out.print("\n" + Cores.WHITE_BOLD + "     Tipo de produto (1-Colecionável, 2-Vestuário Geek, 3-Decoração Geek, 4-Tecnologia, 5-Literatura Geek): " + Cores.RESET);
                int tipo = scanner.nextInt();
                scanner.nextLine();

                System.out.print("\n" + Cores.WHITE_BOLD + "     Nome do produto: " + Cores.RESET);
                String nome = scanner.nextLine();

                System.out.print("\n" + Cores.WHITE_BOLD + "     Preço: " + Cores.RESET);
                double preco = scanner.nextDouble();
                scanner.nextLine();

                Produto produto;

                if (tipo == 1) {
                    System.out.print("\n" + Cores.WHITE_BOLD + "     Franquia (ex.: Star Wars): " + Cores.RESET);
                    String franquia = scanner.nextLine();
                    produto = new ProdutoColecionaveis(nome, preco, franquia);

                } else if (tipo == 2) {
                    System.out.print("\n" + Cores.WHITE_BOLD + "     Tamanho (ex.: M): " + Cores.RESET);
                    String tamanho = scanner.nextLine();
                    produto = new ProdutoVestuario(nome, preco, tamanho);

                } else if (tipo == 3) {
                    System.out.print("\n" + Cores.WHITE_BOLD + "     Material (ex.: Madeira): " + Cores.RESET);
                    String material = scanner.nextLine();
                    produto = new ProdutoDecoracao(nome, preco, material);

                } else if (tipo == 4) {
                    System.out.print("\n" + Cores.WHITE_BOLD + "     Especificação Técnica (ex.: Teclado Mecânico RGB): " + Cores.RESET);
                    String especificacaoTecnica = scanner.nextLine();
                    produto = new ProdutoTecnologia(nome, preco, especificacaoTecnica);

                } else if (tipo == 5) {
                    System.out.print("\n" + Cores.WHITE_BOLD + "     Autor (ex.: J.K. Rowling): " + Cores.RESET);
                    String autor = scanner.nextLine();
                    produto = new ProdutoLiteratura(nome, preco, autor);

                } else {
                    System.out.println(Cores.YELLOW_PASTEL 
                        + "\nTipo inválido!" 
                        + Cores.RESET);
                    break;
                }

                produtos.add(produto);

                case 2:
                    if (produtos.isEmpty()) {
                        System.out.println(Cores.YELLOW_PASTEL 
                            + "\nNenhum produto cadastrado." 
                            + Cores.RESET);
                    } else {
                        for (Produto produtoCadastrado : produtos) {
                            produtoCadastrado.exibirDetalhes();
                            System.out.println("--------------------");
                        }
                    }

                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine();
                    break;

                case 3:
                    executando = false;
                    break;

                default:
                    System.out.println(Cores.YELLOW_PASTEL 
                        + "\nOpção inválida! Tente novamente." 
                        + Cores.RESET);
            }
        }

        scanner.close();
    }
}
