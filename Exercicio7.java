import java.util.Arrays;
import java.util.Scanner;

public class Exercicio7 {

    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Jogo da Velha Interativo ---");
        inicializarTabuleiro();
        
        boolean jogoEmAndamento = true;
        while (jogoEmAndamento) {
            exibirTabuleiro();
            fazerJogada();
            
            if (verificarVitoria()) {
                exibirTabuleiro();
                System.out.println("Parabéns! O Jogador " + jogadorAtual + " venceu!");
                jogoEmAndamento = false;
            } else if (verificarEmpate()) {
                exibirTabuleiro();
                System.out.println("O jogo terminou em empate!");
                jogoEmAndamento = false;
            } else {
                trocarJogador();
            }
        }
        scanner.close();
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(tabuleiro[i], ' ');
        }
    }

    private static void exibirTabuleiro() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void fazerJogada() {
        int linha = -1;
        int coluna = -1;
        boolean jogadaValida = false;

        while (!jogadaValida) {
            System.out.println("Jogador " + jogadorAtual + ", digite sua jogada (linha e coluna, ex: 1 3):");
            
            if (scanner.hasNextInt()) {
                linha = scanner.nextInt() - 1; // Ajuste para índice 0
            } else {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.next(); // Limpar o buffer
                continue;
            }
            
            if (scanner.hasNextInt()) {
                coluna = scanner.nextInt() - 1; // Ajuste para índice 0
            } else {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.next(); // Limpar o buffer
                continue;
            }

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
                if (tabuleiro[linha][coluna] == ' ') {
                    tabuleiro[linha][coluna] = jogadorAtual;
                    jogadaValida = true;
                } else {
                    System.out.println("Posição já ocupada. Tente novamente.");
                }
            } else {
                System.out.println("Posição inválida. As linhas e colunas devem ser entre 1 e 3.");
            }
        }
    }

    private static void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    private static boolean verificarVitoria() {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) ||
                (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)) {
                return true;
            }
        }
        // Verifica diagonais
        if ((tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
            (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)) {
            return true;
        }
        return false;
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false; // Ainda há espaços vazios
                }
            }
        }
        return true; // Tabuleiro cheio e ninguém ganhou
    }
}
