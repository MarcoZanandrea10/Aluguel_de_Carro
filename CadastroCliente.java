import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class CadastroCliente  {

    public static void cadastrarCliente() {
        
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente(null, null, null, 0, false);
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");      // formato para data de nascimento
        
        System.out.println("\n-CADASTRO DE NOVO USUÁRIO-\n");

        // Nome
        System.out.print("Nome: ");
        cliente.setNome(sc.next());

        // Data de Nascimento
        System.out.print("Data de Nascimento (dd/mm/yyyy): ");
        String dataNascimentoStr = sc.next();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatoData);
        LocalDate hoje = LocalDate.now();   // pega a data atual
        Period periodo = Period.between(dataNascimento, hoje);  // calcula a diferença entre a data de nascimento e a data atual
        if (periodo.getYears() >= 18) {     // verifica se o usuário é maior de 18 anos
        } else {
            System.out.println("\nUsuário menor de 18 anos.");

        }
        cliente.setIdade(dataNascimento);      // dataNascimento é o setIdade

        // CPF
        System.out.print("CPF: ");
        cliente.setCpf(sc.next());
        if (cliente.getCpf().length() != 11) {      // verifica se o CPF tem 11 dígitos
            System.out.println("\nCPF inválido. Tente novamente.\n");
        }
        if (cpfJaExiste(cliente.getCpf())) {        // verifica se o CPF ja esta cadastrado
            System.out.println("\nCPF já cadastrado. Por favor faça login.");
            return;
        }

        // Possui CNH?
        System.out.print("Possui CNH? (s/n): ");
        cliente.setHabilitado(sc.next().equalsIgnoreCase("s"));
        if (!cliente.isHabilitado()) {      // se o usuário não possui CNH
            System.out.println("\nUsuário não possui CNH. Cadastro não realizado.\n");
        }

        // Número da CNH
        System.out.print("Número da CNH: ");
        cliente.setNumeroCNH(sc.nextInt());
        
        System.out.println(cliente);    // inf do cliente na tela
        
        try (java.io.FileWriter fw = new java.io.FileWriter("usuarios.txt", true)) {     // escreve no arquivo
            fw.write(cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getIdade().format(formatoData) + ";" + cliente.getNumeroCNH() + ";" + cliente.isHabilitado() + "\n");     // salva os dados do usuário no arquivo usuarios.txt
            System.out.println("\nUsuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());    // caso ocorra erro
        }

    }
        
    private static boolean cpfJaExiste(String cpf) {
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("usuarios.txt"))) {      //  le o arquivo usuarios.txt
            String linha;       
            while ((linha = br.readLine()) != null) {         // le cada linha do arquivo
                String[] dados = linha.split(";");      // divide a linha por ;
                if (dados.length >= 2 && dados[1].equals(cpf)) {    // verifica se o CPF ja existe
                    return true; 
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar CPF: " + e.getMessage());     // caso ocorra erro
        }
        return false;
    }

}