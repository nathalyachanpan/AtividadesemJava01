import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio4 {

    private static void exibirLista(List<String> lista) {
        System.out.println("\n--- Lista de Espera Atualizada ---");
        if (lista.isEmpty()) {
            System.out.println("A lista de espera está vazia.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i));
            }
        }
        System.out.println("Total de clientes aguardando: " + lista.size());
    }

    public static void main(String[] args) {
        List<String> listaEspera = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.println("--- Organizando uma Lista de Espera Dinâmica ---");

        while (opcao != 0) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Remover primeiro cliente (atendido)");
            System.out.println("3. Exibir lista");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do cliente a adicionar: ");
                        String nome = scanner.nextLine();
                        listaEspera.add(nome);
                        System.out.println("Cliente " + nome + " adicionado.");
                        exibirLista(listaEspera);
                        break;
                    case 2:
                        if (!listaEspera.isEmpty()) {
                            String clienteAtendido = listaEspera.remove(0);
                            System.out.println("Cliente " + clienteAtendido + " removido (atendido).");
                        } else {
                            System.out.println("A lista de espera já está vazia.");
                        }
                        exibirLista(listaEspera);
                        break;
                    case 3:
                        exibirLista(listaEspera);
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema de lista de espera.");
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
