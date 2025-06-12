import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DisponibilidadeVeiculo {

    public static void atualizarDisponibilidade(String buscarModelo, boolean novaDisponibilidade) {
        File inputFile = new File("veiculos.txt");
        File tempFile = new File("veiculos_temp.txt");      // arquivo temporário 

        // le o arquivo original e o arquivo temporário
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String linha;

            while ((linha = reader.readLine()) != null) {   // le cada linha do arquivo original
                String[] dados = linha.split(";");

                if (dados.length == 7 && dados[1].equalsIgnoreCase(buscarModelo)) {      // verifica se modelo do veículo é igual a buscarModelo
                    dados[5] = String.valueOf(novaDisponibilidade);     // atualiza a disponibilidade do veículo
                    linha = String.join(";", dados);          // junta os dados novamente em uma linha
                }

                writer.write(linha);     // escreve a linha no arquivo temporário
                writer.newLine();       
            }

            reader.close();     // fecha o leitor do arquivo original
            writer.close();     // fecha o escritor do arquivo temporário

                
            if (!inputFile.delete()) {      // substitui o arquivo original
                System.out.println("Erro ao deletar o arquivo original.");      // caso ocorra erro
                return;
            }
            if (!tempFile.renameTo(inputFile)) {     // renomeia o arquivo temporário para o nome do arquivo original
                System.out.println("Erro ao renomear o arquivo temporário.");   // caso ocorra erro
            }

        } catch (IOException e) {
            System.out.println("Erro ao atualizar disponibilidade: " + e.getMessage());     //caso ocorra erro
        }
    }
}