import java.time.LocalDate;

public class Cliente {

    // dados do cliente
    private String nome;
    private String cpf;
    private LocalDate idade;
    private int numeroCNH;
    private boolean habilitado;

    public Cliente(String nome, String cpf, LocalDate idade, int numeroCNH, boolean habilitado) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.numeroCNH = numeroCNH;
        this.habilitado = habilitado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate dataNascimento) {
        this.idade = dataNascimento;
    }

    public int getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(int numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override   // sobrescreve o método toString da classe Object
    public String toString() {      // função para mostrar informações do cliente
        return "\nInformações do Usuário:\n" + 
                "\nNome: " + nome + 
                "\nCPF: " + cpf + 
                "\nIdade: " + idade + 
                "\nHabilitado: " + (habilitado ? "Sim" : "Não") +
                "\nNúmero da CNH: " + numeroCNH; 
    }
}