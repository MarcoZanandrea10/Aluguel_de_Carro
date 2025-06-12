import java.io.BufferedReader;
import java.io.FileReader;

public class ListaVeiculos {

     public static void mostrarVeiculosDisponiveis() {
        try (BufferedReader br = new BufferedReader(new FileReader("veiculos.txt"))) {
            String linha;                           
            boolean encontrou = false;

            System.out.println("\n--- VEÍCULOS DISPONÍVEIS ---\n");

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados.length == 7 && dados[5].equalsIgnoreCase("true")) {       // verifica se o veículo está disponível
                    String tipo = dados[6];     // pega o tipo do veículo   
                    Veiculo veiculo;

                    switch (tipo) {
                        case "Sedan":
                            veiculo = new Sedan(dados[0], dados[1], dados[2], dados[3],
                                    Integer.parseInt(dados[4]), true);
                            break;
                        case "SUV":
                            veiculo = new SUV(dados[0], dados[1], dados[2], dados[3],
                                Integer.parseInt(dados[4]), true);
                            break;
                        case "Esportivo":
                                veiculo = new Esportivo(dados[0], dados[1], dados[2], dados[3],
                                    Integer.parseInt(dados[4]), true);
                            break;
                        default:
                            continue; // pula se o tipo for inválido
                    }

                    System.out.println(veiculo);
                    encontrou = true;
                    }
                }

            if (!encontrou) {
                System.out.println("Nenhum veículo disponível no momento.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler veículos: " + e.getMessage());
        }
    }
}