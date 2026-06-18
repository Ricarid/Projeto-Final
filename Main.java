import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- SISTEMA DE CADASTRO DE PRODUTOS ---");
            System.out.println("1. Adicionar novo produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Remover produto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o ID do produto: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o nome do produto: ");
                        String nome = scanner.nextLine();

                        System.out.print("Digite a quantidade: ");
                        int quantidade = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o preço: ");
                        double preco = Double.parseDouble(scanner.nextLine().replace(",", "."));

                        Produto p = new Produto(id, nome, quantidade, preco);
                        gerenciador.adicionarProduto(p);
                        System.out.println("Produto cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.println("\n--- LISTA DE PRODUTOS ---");
                        gerenciador.listarProdutos();
                        break;

                    case 3:
                        System.out.print("Digite o ID do produto que deseja remover: ");
                        int idRemover = Integer.parseInt(scanner.nextLine());
                        gerenciador.removerProduto(idRemover);
                        break;

                    case 4:
                        System.out.println("Encerrando o sistema... Até logo!");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira um valor numérico válido.");
            }
        }
        scanner.close();
    }
}