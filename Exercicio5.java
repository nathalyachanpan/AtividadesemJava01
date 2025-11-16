public class Exercicio5 {
    public static void main(String[] args) {
        // Criação da matriz (array) com as notas dos alunos
        double[] notas = {7.5, 9.0, 6.0, 8.5, 10.0, 5.5, 7.0};
        
        // Variável para armazenar a maior nota, inicializada com o menor valor possível
        double maiorNota = Double.MIN_VALUE;
        
        System.out.println("--- Avaliação de Notas dos Alunos ---");
        System.out.print("Notas da turma: ");
        for (double nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println();

        // Percorre o array para encontrar a maior nota
        for (double nota : notas) {
            if (nota > maiorNota) {
                maiorNota = nota;
            }
        }
        
        // Exibe a maior nota encontrada
        System.out.println("A maior nota da turma é: " + maiorNota);
    }
}
