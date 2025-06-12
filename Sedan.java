public class Sedan extends Veiculo{

    public Sedan(String placa, String modelo, String marca, String cor, int ano, boolean disponivel) {
        super(modelo, marca, placa, cor, ano, disponivel);
    }

    @Override
    public String getTipo() {
        return "Sedan";
    }

}