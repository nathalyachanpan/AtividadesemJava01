public class Exercicio6 {

    // Função para verificar se um número é primo
    public static boolean isPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        // Um número é primo se for divisível apenas por 1 e por ele mesmo.
        // Basta verificar divisibilidade até a raiz quadrada do número.
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("--- Seleção de Números Primos para Criptografia ---");
        System.out.println("Números primos entre 1 e 100:");
        
        int contador = 0;
        for (int i = 1; i <= 100; i++) {
            if (isPrimo(i)) {
                System.out.print(i + " ");
                contador++;
                // Quebra de linha a cada 10 números para melhor visualização
                if (contador % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("\nTotal de números primos encontrados: " + contador);
    }
}
