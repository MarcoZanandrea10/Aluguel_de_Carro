import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Aluguel {

    private Veiculo veiculo;
    private double valorDiario;
    private double valorHora;
    private double valorSeguro;
    private int dias;
    private double horas;
    private double valorTotal;

    public Aluguel(Veiculo veiculo, int dias, double horas) {
        this.veiculo = veiculo;
        this.dias = dias;
        this.horas = horas;
        valoresPorTipo();
        calcularValorTotal();
    }

    public void valoresPorTipo() {
        switch (veiculo.getTipo()) {    //valores e seguros dos carros
            case "Sedan":
                valorDiario = 150;
                valorHora = 40;
                valorSeguro = 50;
                break;
            case "SUV":
                valorDiario = 250;
                valorHora = 60;
                valorSeguro = 80;
                break;
            case "Esportivo":
                valorDiario = 400;
                valorHora = 100;
                valorSeguro = 100;
                break;
            default:
                System.out.println("\nTipo de veículo desconhecido.");
                break;
        }
    }

    private void calcularValorTotal() {

        if (horas <= 12) {
            double horasTotais = horas / 24.0; // proporcional
            valorTotal = (valorHora + valorSeguro) * horasTotais;
        } else {
            double diasTotais = (double) Math.ceil(horas / 24.0); // arredonda para cima
            valorTotal = (valorDiario + valorSeguro) * diasTotais;
        }
    }

    public void totalDoAluguel() {      // mostra o resumo do aluguel
        System.out.println("\n---TOTAL DO ALUGUEL---\n");
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Tipo: " + veiculo.getTipo());
        if (horas <= 12) {
            System.out.println("Tempo de uso: " + horas + " hora(s)");
        } else {
            System.out.println("Tempo de uso: " + dias + " dia(s)");
        }
        System.out.printf("Valor total (aluguel + seguro): R$ %.2f%n", valorTotal);    
    }

    public static Aluguel iniciarAluguel(Veiculo veiculo) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try {
            System.out.print("Data e hora da retirada (dd/MM/yyyy HH:mm): ");
            String retirada = sc.nextLine();
            LocalDateTime retiradaDataHora = LocalDateTime.parse(retirada, formatoDataHora);

            System.out.print("Data e hora da devolução (dd/MM/yyyy HH:mm): ");
            String devolucao = sc.nextLine();
            LocalDateTime devolucaoDataHora = LocalDateTime.parse(devolucao, formatoDataHora);

            if (devolucaoDataHora.isBefore(retiradaDataHora)) {      // caso devolução seja antes da retirada
                System.out.println("\nA devolução não pode ser antes da retirada.");
                return null;
            }

            double dias = Duration.between(retiradaDataHora, devolucaoDataHora).toDays();       // calcula a diferença em dias
            double horas = Duration.between(retiradaDataHora, devolucaoDataHora).toHours();     // calcula a diferença em horas
            return new Aluguel(veiculo, (int) dias, horas);     // cria um novo objeto Aluguel com os dados informados

        } catch (Exception e) {
            System.out.println("\nUse esse formato (dd/MM/yyyy HH:mm)");      // caso ocorra erro
            return null;
        }
    }

}