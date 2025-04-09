import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1, num2;

        System.out.println("Digite um número: ");
        num1 = sc.nextInt();
        System.out.println("Digite outro número: ");
        num2 = sc.nextInt();

        System.out.println("O resultado da soma é: " + (num1 +num2));
    }
}
