import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mediaAvaliacao = 0;
        double nota = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite sua nota: ");
            nota = scanner.nextDouble();
            mediaAvaliacao += nota;
        }

        System.out.printf("Média de avaliações %.2f", mediaAvaliacao/3);
    }
}
