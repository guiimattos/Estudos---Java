import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua idade:");
        int idade = scanner.nextInt();

        System.out.println("Voce tem ingresso? true/false:");
        boolean temIngresso = scanner.nextBoolean();

        if (idade >= 18 && temIngresso && true ) {
            System.out.println("Entrada permitida");
        } else {
            System.out.println("Entrada negada");
        }
        
        scanner.close();
    }
}
