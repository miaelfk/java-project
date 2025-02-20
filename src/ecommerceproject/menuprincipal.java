package ecommerceproject;

import ecommerceproject.utils.Cores;
import java.util.Scanner;

public class menuprincipal {
    public static void main(String[] args) {
        String[] produtos = new String[5];
        double[] precos = new double[5];
        int estoque = 0;

        boolean executando = true;
        Scanner scanner = new Scanner(System.in);

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
                    if (estoque >= produtos.length) {
                        System.out.println(Cores.YELLOW_PASTEL + "Estoque cheio! Não é possível cadastrar mais produtos." + Cores.RESET);
                        break;
                    }

                    System.out.print("\n" + Cores.WHITE_BOLD + "     Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("\n" + Cores.WHITE_BOLD + "     Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    produtos[estoque] = nome;
                    precos[estoque] = preco;

                    estoque++;

                    System.out.println(Cores.YELLOW_PASTEL + "\nO produto \"" + nome + "\" foi adicionado ao catálogo com sucesso!" + Cores.RESET);
                    break;

                case 2:
                    if (estoque == 0) {
                        System.out.println(Cores.YELLOW_PASTEL + "Nenhum produto cadastrado." + Cores.RESET);
                    } else {
                        for (int i = 0; i < estoque; i++) {
                            System.out.println(produtos[i] + " - R$ " + precos[i]);
                        }
                    }

                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine();
                    break;

                case 3:
                    executando = false;
                    break;

                default:
                    System.out.println(Cores.YELLOW_PASTEL + "Opção inválida! Tente novamente." + Cores.RESET);
            }
        }

        scanner.close();
    }
}
