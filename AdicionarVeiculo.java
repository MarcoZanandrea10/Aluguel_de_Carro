import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdicionarVeiculo {

    public static void adicionarVeiculo() throws IOException {

        Scanner sc = new Scanner(System.in);
        Veiculo veiculo = new Veiculo(null, null, null, null, 0, true); // Cria um novo objeto Veiculo

        String nomeAdm = "admin";   // nome do administrador pré definido
        String senhaAdm = "1234";   // senha do administrador pré definido
        String nomeAdmEntrada;
        String senhaAdmEntrada;
        
        System.out.println("\n---ADICIONAR VEÍCULO---\n");

        System.out.print("Usúario: ");
        nomeAdmEntrada = sc.nextLine();

        System.out.print("Senha: ");
        senhaAdmEntrada = sc.nextLine();

        if (!nomeAdmEntrada.equals(nomeAdm) || !senhaAdmEntrada.equals(senhaAdm)) {     // verifica se o usuário e a senha estão corretos
            System.out.println("\nUsuário ou senha inválidos.");
            return;
        }

        if (nomeAdmEntrada.equals(nomeAdm) && senhaAdmEntrada.equals(senhaAdm)) {     // se o usuário e a senha estiverem corretos
        
            System.out.println("\n---ADICIONAR VEÍCULO---\n");
            System.out.println("Bem vindo Chefe!\n");

            //Tipo do veículo
            System.out.println("Tipo do veículo:");
            System.out.println("1 - Sedan");
            System.out.println("2 - SUV");
            System.out.println("3 - Esportivo");
            System.out.print("\nEscolha: ");
            int tipo = sc.nextInt();
            sc.nextLine();     // limpa o buffer 

            String tipoVeiculo;     // variável para armazenar o tipo do veículo
            switch (tipo) {
                case 1: tipoVeiculo = "Sedan"; break;
                case 2: tipoVeiculo = "SUV"; break;
                case 3: tipoVeiculo = "Esportivo"; break;
                default:
                    System.out.println("Tipo inválido.");
                    return;
            }   
        
            //Dados do veículo
            System.out.println("Digite os dados do veículo:");
            System.out.print("Modelo: ");
            veiculo.setModelo(sc.nextLine());
            System.out.print("Marca: ");
            veiculo.setMarca(sc.nextLine());
            System.out.print("Placa: ");
            veiculo.setPlaca(sc.nextLine());
            System.out.print("Cor: ");
            veiculo.setCor(sc.nextLine());
            System.out.print("Ano: ");
            veiculo.setAno(sc.nextInt());
            veiculo.setDisponivel(true);

            // antes do try(FileWriter...)
            File arquivo = new File("veiculos.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            try (FileWriter fw = new FileWriter("veiculos.txt", true)) { // já cria se não existir
                fw.write(veiculo.getPlaca() + ";" + veiculo.getModelo() + ";" + veiculo.getMarca() + ";" + veiculo.getCor() + ";" + veiculo.getAno() + ";" + veiculo.getDisponivel() + ";" + tipoVeiculo + "\n" );
                System.out.println("\nVeículo adicionado com sucesso!");
            } catch (Exception e) {
                System.out.println("\nErro ao salvar veículo: " + e.getMessage());
            }


        }
    }
}
