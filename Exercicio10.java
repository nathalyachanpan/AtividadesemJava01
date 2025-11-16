import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio10 {

    private static List<Produto> estoque = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        System.out.println("--- Sistema de Gerenciamento de Estoque ---");

        while (opcao != 0) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Item ao Estoque");
            System.out.println("2. Listar Estoque");
            System.out.println("3. Atualizar Item (Quantidade/Preço)");
            System.out.println("4. Remover Item");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        adicionarItem();
                        break;
                    case 2:
                        listarEstoque();
                        break;
                    case 3:
                        atualizarItem();
                        break;
                    case 4:
                        removerItem();
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema de gerenciamento de estoque.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpar o buffer
                opcao = -1; // Para continuar o loop
            }
        }
        scanner.close();
    }

    private static void adicionarItem() {
        System.out.println("\n--- Adicionar Item ---");
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = lerInteiro();

        System.out.print("Preço: ");
        double preco = lerDouble();

        Produto novoProduto = new Produto(nome, quantidade, preco);
        estoque.add(novoProduto);
        System.out.println("Produto '" + nome + "' adicionado ao estoque.");
    }

    private static void listarEstoque() {
        System.out.println("\n--- Estoque Atual ---");
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            for (int i = 0; i < estoque.size(); i++) {
                System.out.println((i + 1) + ". " + estoque.get(i));
            }
        }
    }

    private static void atualizarItem() {
        listarEstoque();
        if (estoque.isEmpty()) return;

        System.out.print("\nDigite o número do item que deseja atualizar: ");
        int indice = lerInteiro() - 1;

        if (indice >= 0 && indice < estoque.size()) {
            Produto produto = estoque.get(indice);
            System.out.println("Produto selecionado: " + produto.getNome());

            System.out.print("Nova Quantidade (atual: " + produto.getQuantidade() + "): ");
            int novaQuantidade = lerInteiro();
            produto.setQuantidade(novaQuantidade);

            System.out.print("Novo Preço (atual: R$ " + String.format("%.2f", produto.getPreco()) + "): ");
            double novoPreco = lerDouble();
            produto.setPreco(novoPreco);

            System.out.println("Produto '" + produto.getNome() + "' atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void removerItem() {
        listarEstoque();
        if (estoque.isEmpty()) return;

        System.out.print("\nDigite o número do item que deseja remover: ");
        int indice = lerInteiro() - 1;

        if (indice >= 0 && indice < estoque.size()) {
            Produto produtoRemovido = estoque.remove(indice);
            System.out.println("Produto '" + produtoRemovido.getNome() + "' removido do estoque.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Métodos auxiliares para leitura segura de entrada
    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next(); // Limpar o buffer
            System.out.print("Tente novamente: ");
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        return valor;
    }

    private static double lerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, digite um número com ponto flutuante (ex: 19.99).");
            scanner.next(); // Limpar o buffer
            System.out.print("Tente novamente: ");
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha
        return valor;
    }
}
