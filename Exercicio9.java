import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio9 {

    private static void adicionarCliente(List<Pessoa> lista, Scanner scanner) {
        System.out.println("\n--- Adicionar Novo Cliente ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        int idade = -1;
        while (idade < 0) {
            System.out.print("Idade: ");
            if (scanner.hasNextInt()) {
                idade = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
            } else {
                System.out.println("Idade inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpar o buffer
            }
        }
        
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Pessoa novoCliente = new Pessoa(nome, idade, endereco);
        lista.add(novoCliente);
        System.out.println("Cliente " + nome + " cadastrado com sucesso!");
    }

    private static void listarClientes(List<Pessoa> lista) {
        System.out.println("\n--- Lista de Clientes Cadastrados ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i));
            }
        }
    }

    public static void main(String[] args) {
        List<Pessoa> cadastroClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.println("--- Gerenciamento de Cadastro de Clientes ---");

        while (opcao != 0) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar novo cliente");
            System.out.println("2. Listar todos os clientes");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        adicionarCliente(cadastroClientes, scanner);
                        break;
                    case 2:
                        listarClientes(cadastroClientes);
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema de cadastro.");
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
}
