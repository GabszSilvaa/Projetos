
public class ItemMenu {

    // ATRIBUTOS
    private int id;
    private String nome;
    private double preco;
    private int quantidade = 1;

    // CONSTRUTOR
    public ItemMenu(int id, String nome, double preco) {

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    
    public int getId() {
        return id;
    }

    
    public String getNome() {
        return nome;
    }

    
    public double getPreco() {
        return preco;
    }

    
    public int getQuantidade() {
        return quantidade;
    }

    
    public void aumentarQuantidade() {
        quantidade++;
    }

   
    public void diminuirQuantidade() {

        if (quantidade > 0) {
            quantidade--;
        }
    }

    
    @Override
    public String toString() {

        return "ID: " + id
                + " | " + nome
                + " | Preço: R$ " + String.format("%.2f", preco);
    }
}
