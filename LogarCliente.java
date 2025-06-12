import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LogarCliente {

    public static Cliente logarCliente() {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\n-ENTRAR COM USUÁRIO-\n");     // entrar com dados do usuário ja cadastrado

        System.out.print("Nome: ");
        String nomeEntrada = sc.next();     // variável temporária para verificar o nome do usuário

        System.out.print("CPF: ");
        String cpfEntrada = sc.next();      // variável temporaria para verificar o cpf do usuário

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("usuarios.txt"))) {      // le o arquivo usuarios.txt
        String linha;
        while ((linha = br.readLine()) != null) {       // le cada linha do arquivo
            String[] dados = linha.split(";");    // divide a linha com ;

            if (dados.length == 5 && dados[0].equalsIgnoreCase(nomeEntrada) && dados[1].equals(cpfEntrada)) {   // verifica se o nome e o cpf do usuário são iguais aos dados do arquivo
                String nome = dados[0];     
                String cpf = dados[1];
                LocalDate dataNascimento = LocalDate.parse(dados[2], formatoData);
                int numeroCNH = Integer.parseInt(dados[3]);
                boolean habilitado = Boolean.parseBoolean(dados[4]);

                System.out.println("\nUsuário logado. Bem-vindo, " + nome + "!");
                return new Cliente(nome, cpf, dataNascimento, numeroCNH, habilitado);   // retorna um objeto Cliente com os dados do usuário
            }
        }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());       // caso ocorra erro
        }

        System.out.println("\nUsuário não encontrado ou dados incorretos.");
        return null;

    }

}