public class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    // Construtor
    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    // Setters (necessários para a função de atualização)
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método toString para facilitar a exibição
    @Override
    public String toString() {
        return "Nome: " + nome + 
               " | Quantidade: " + quantidade + 
               " | Preço: R$ " + String.format("%.2f", preco);
    }
}
