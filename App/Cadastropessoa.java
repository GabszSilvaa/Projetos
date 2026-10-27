package App;

public class Cadastropessoa {

    private String nome;

    public Cadastropessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    private String cpf;

    public Cadastropessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
