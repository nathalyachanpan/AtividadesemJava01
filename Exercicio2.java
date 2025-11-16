import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Verificador de Características de Produto ---");
        System.out.print("Digite o código do produto (número inteiro): ");
        
        // Verifica se a entrada é um número inteiro
        if (scanner.hasNextInt()) {
            int codigoProduto = scanner.nextInt();
            
            // Verifica se o número é par ou ímpar
            if (codigoProduto % 2 == 0) {
                System.out.println("O código do produto " + codigoProduto + " é PAR.");
            } else {
                System.out.println("O código do produto " + codigoProduto + " é ÍMPAR.");
            }
        } else {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
        }
        
        scanner.close();
    }
}
