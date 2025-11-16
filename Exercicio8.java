import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pedidos = new ArrayList<>();

        System.out.println("--- Análise de Frequência de Pedidos no Delivery ---");
        System.out.println("Digite os códigos dos pedidos (números inteiros). Digite '0' para finalizar a entrada.");

        int codigo;
        while (true) {
            System.out.print("Código do pedido: ");
            if (scanner.hasNextInt()) {
                codigo = scanner.nextInt();
                if (codigo == 0) {
                    break;
                }
                pedidos.add(codigo);
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Limpar o buffer
            }
        }
        scanner.close();

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido foi inserido para análise.");
            return;
        }

        // 1. Contar a frequência de cada código de pedido
        Map<Integer, Integer> frequencia = new HashMap<>();
        for (int pedido : pedidos) {
            frequencia.put(pedido, frequencia.getOrDefault(pedido, 0) + 1);
        }

        // 2. Encontrar o código de pedido mais frequente
        int itemMaisPedido = -1;
        int maiorFrequencia = -1;

        for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > maiorFrequencia) {
                maiorFrequencia = entry.getValue();
                itemMaisPedido = entry.getKey();
            }
        }

        System.out.println("\n--- Resultado da Análise ---");
        System.out.println("Lista de pedidos inseridos: " + pedidos);
        System.out.println("O item que mais se repete (código) é: " + itemMaisPedido);
        System.out.println("Frequência de repetição: " + maiorFrequencia + " vezes.");
    }
}
