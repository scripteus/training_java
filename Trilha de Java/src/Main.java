import java.util.Locale;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

            System.out.println("Escolha uma conversão: ");
            System.out.println("1 - Metros para centímetros");
            System.out.println("2 - Quilos para gramas");
            System.out.println("3 - Horas para minutos");
            System.out.println("4 - Celsius para Fahrenheit");

            System.out.println("Digite sua opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor em metros: ");
                    double meters = scanner.nextDouble();
                    double centimeters = meters * 100;
                    System.out.printf("%.2f metros é igual a %.2f centímetros.", meters, centimeters);
                    break;

                case 2:
                    System.out.println("Digite o valor em quilos: ");
                    double kilos = scanner.nextDouble();
                    double grams = kilos * 1000;
                    System.out.printf("%.2f quilos é igual a %.2f gramas.", kilos, grams);
                    break;

                case 3:
                    System.out.println("Digite o valor em horas: ");
                    double hours = scanner.nextDouble();
                    double minutes = hours * 60;
                    System.out.printf("%.2f horas é igual a %.2f minutos.", hours, minutes);
                    break;

                case 4:
                    System.out.println("Digite o valor em Celsius: ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = (celsius * 9/5) + 32;
                    System.out.printf("%.2f Celsius é igual a %.2f Fahrenheit.", celsius,fahrenheit);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
            scanner.close();
        }
    }