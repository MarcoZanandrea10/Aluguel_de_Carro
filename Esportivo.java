public class Esportivo extends Veiculo{

    public Esportivo(String placa, String modelo, String marca, String cor, int ano, boolean disponivel) {
        super(modelo, marca, placa, cor, ano, disponivel);
    }

    @Override
    public String getTipo() {
        return "Esportivo";
    }

}