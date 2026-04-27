import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seu nome:");

        System.out.println("Digite o valor da sua compra:");
        int valor = scanner.nextInt();

        System.out.println("Digite sua idade:");

        System.out.println("Voce e estudante? true/false");
        boolean estudante = scanner.nextBoolean();

        if (valor >= 500) {
            System.out.println("desconto de 15%");
        }

        scanner.close();
    }
}
