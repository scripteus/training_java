import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double amount = 5000.00;
        System.out.println("Seja bem vindo(a) ao Sicoob Credialto!");
        System.out.println("Para acessar sua conta digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (cpf.equals("14481288620") && senha.equals("12345")) {
            System.out.println("Conta encontrada!");
            System.out.println("*************************************");
            System.out.println("Nome: Matheus Henrique Silva Souza");
            System.out.printf("Saldo: %.2f\n", amount);
            System.out.println("Conta: 24698-9");
            System.out.println("Agência: 4427");
            System.out.println("*************************************");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Extrato");
            System.out.println("5 - Sair");
            int option = scanner.nextInt();

            while (option != 5) {

                switch (option) {
                    case 1:
                        System.out.println("Digite o valor a ser depositado: ");
                        double valorDeposito = scanner.nextDouble();
                        System.out.printf("Você depositou R$ %.2f", valorDeposito);
                        amount += valorDeposito;
                        break;

                    case 2:
                        System.out.println("Digite o valor a sacar: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAmount > amount) {
                            System.out.println("Saldo insuficiente.");
                        } else {
                            amount -= withdrawAmount;
                            System.out.printf("Você sacou R$ %.2f", withdrawAmount);
                        }
                        break;
                    case 3:
                        System.out.println("Digite o valor que você quer transferir: ");
                        double transferAmount = scanner.nextDouble();
                        if (transferAmount > amount) {
                            System.out.println("Saldo insuficiente.");
                        } else {
                            amount -= transferAmount;
                            System.out.printf("Você transferiu R$ %.2f", transferAmount);
                        }
                        break;
                    case 4:
                        System.out.println("Extrato:");
                        System.out.println("*************************************");
                        System.out.println("Nome: Matheus Henrique Silva Souza");
                        System.out.printf("Saldo: %.2f\n", amount);
                        System.out.println("Conta: 24698-9");
                        System.out.println("Agência: 4427");
                        System.out.println("*************************************");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

                System.out.println("\nEscolha outra opção: ");
                option = scanner.nextInt();

            }
        }
    }
}
