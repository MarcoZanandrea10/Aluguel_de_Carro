public class Veiculo {

    // Atributos do veículo 
    private String modelo;
    private String marca;
    private String placa;
    private String cor;
    private int ano;
    private boolean disponivel = true; 

    public Veiculo(String modelo, String marca, String placa, String cor, int ano, boolean disponivel) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.disponivel = disponivel;
        
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTipo() {       // função para retornar o tipo do veículo
        return "\nVeículo genérico";  // tipo padrão
    }

    @Override
    public String toString() {      // funcao para mostrar informações do veículo
        return "\nVeiculo: " + getTipo() +
               "\nModelo: " + modelo +
               "\nMarca: " + marca +
               "\nPlaca: " + placa +
               "\nCor: " + cor +
               "\nAno: " + ano + 
               "\nDisponível: "+ (disponivel ? "Sim" : "Não");  

    } 
}