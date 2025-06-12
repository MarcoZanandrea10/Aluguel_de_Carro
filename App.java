import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n---ALUGUEL DE CARROS---\n");
            System.out.println("1- Entrar com usuário.");
            System.out.println("2- Cadastrar novo usuário.");
            System.out.println("3- Sair.");

            System.out.print("\nEscolha uma opção: ");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:     // opcao 1
                    Cliente clienteLogado = LogarCliente.logarCliente();    // chama a classe LogarCliente para logar o usuário
                    if (clienteLogado == null) {        // se o usuário não for encontrado retorna null
                        break; 
                    }
                    
                    while (opcao != 4) {
                    System.out.println("\n---ALUGUEL DE CARROS---\n");
                    System.out.println("1- Alugar carro.");
                    System.out.println("2- Ver lista de carros disponíveis.");
                    System.out.println("3- Adicionar Carro.");
                    System.out.println("4- Sair.");

                    System.out.print("\nEscolha uma opção: ");
                    opcao = sc.nextInt();

                    switch (opcao) {
                        case 1:     // opcao 1
                            System.out.print("\nDigite o modelo do veículo que deseja alugar: ");
                            String modelo = sc.next();

                            Veiculo veiculo = BuscarVeiculoPorModelo.buscarModelo(modelo);      // chama a classe BuscarVeiculoPorModelo para buscar o veículo pelo modelo
                            if (veiculo != null) {      // se o veículo for encontrado
                                Aluguel aluguel = Aluguel.iniciarAluguel(veiculo);
                                if (aluguel != null) {
                                    aluguel.totalDoAluguel(); // mostra o resumo do aluguel
                                    DisponibilidadeVeiculo.atualizarDisponibilidade(veiculo.getModelo(), false); // atualiza a disponibilidade do veículo para false
                                } else {
                                    System.out.println("\nErro ao iniciar o aluguel.");
                                }
                            } else {
                                System.out.println("\nVeículo não encontrado ou indisponível.");
                            }

                            break;
                        case 2:     // opcao 2   
                            ListaVeiculos.mostrarVeiculosDisponiveis();
                            break;
                        case 3:     // opcao 3
                            AdicionarVeiculo.adicionarVeiculo();
                            break;
                        case 4:     // opcao 4
                            System.out.println("\nVoçê saiu!\n");
                            System.out.println("Obrigado por usar nosso sistema de aluguel de carros!\n");
                            break;
                        default:        // opcao inválida
                            System.out.println("\nOpção inválida. Tente novamente.\n");
                            break;
                        }
                    }
                    break;

                case 2:     // opcao 2
                    CadastroCliente.cadastrarCliente();
                    break;
                case 3:    // opcao 3
                    System.out.println("\nVocê saiu!\n");
                    System.out.println("Obrigado por usar nosso sistema de aluguel de carros!\n");
                    break;
                default:   // opcao inválida
                    System.out.println("\nOpção inválida. Tente novamente.\n");
                    break;
            }
        }
        sc.close();
    }
}