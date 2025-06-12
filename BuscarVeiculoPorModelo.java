import java.io.BufferedReader;
import java.io.FileReader;

public class BuscarVeiculoPorModelo {

    public static Veiculo buscarModelo(String modeloBusca) {
        try (BufferedReader br = new BufferedReader(new FileReader("veiculos.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados.length == 7) {
                    String modelo = dados[1];       // pega o modelo do veículo
                    boolean disponivel = dados[5].equalsIgnoreCase("true");     // verifica se esta disponível

                    if (modelo.equalsIgnoreCase(modeloBusca) && disponivel) {       // verifica se o modelo é igual ao buscado e se está disponível
                        String placa = dados[0];
                        String marca = dados[2];
                        String cor = dados[3];
                        int ano = Integer.parseInt(dados[4]);
                        String tipo = dados[6];

                        switch (tipo) {
                            case "Sedan":
                                return new Sedan(placa, modelo, marca, cor, ano, true);
                            case "SUV":
                                return new SUV(placa, modelo, marca, cor, ano, true);
                            case "Esportivo":
                                return new Esportivo(placa, modelo, marca, cor, ano, true);
                            default:
                                return null; // tipo inválido
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler veículos: " + e.getMessage());      // caso ocorra erro
        }

        return null; // se não encontrar
    }
}