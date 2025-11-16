public class Pessoa {
    private String nome;
    private int idade;
    private String endereco;

    // Construtor
    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    // Método toString para facilitar a exibição
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Endereço: " + endereco;
    }
}
