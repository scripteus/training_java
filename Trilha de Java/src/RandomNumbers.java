import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randomNumber = new Random().nextInt(10);

        System.out.println("Digite um número entre 0 e 10: ");
        int userGuess = scanner.nextInt();

        for (int i = 1; i < 5; i++) {

            if (userGuess == randomNumber) {
                System.out.println("Parabéns! Você acertou o número.");
                break;
            }
            else if (userGuess < randomNumber) {
                System.out.println("O número é maior que " + userGuess);
                System.out.println("Você ainda tem " + (5 - i) + " tentativas.");
            }
            else {
                System.out.println("O número é menor que " + userGuess);
                System.out.println("Você ainda tem " + (5 - i) + " tentativas.");
            }

            System.out.println("Tentativa " + (i + 1) + ": ");
            userGuess = scanner.nextInt();

            if (i == 4) {
                System.out.println("Você perdeu! O número era " + randomNumber);
                System.out.println("Tente novamente.");
                break;
            }

            if (userGuess < 0 || userGuess > 100) {
                System.out.println("Número inválido. Tente novamente.");
                continue;
            }
        }
    }
}
