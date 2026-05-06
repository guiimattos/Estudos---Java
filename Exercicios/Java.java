import java.util.Scanner;

public class Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] linha = new int[5];

        System.out.println("Digite 5 numeros para a matriz de uma linha:");

        for (int i = 0; i < linha.length; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            linha[i] = sc.nextInt();
        }

        System.out.println("Matriz de uma linha:");

        for (int i = 0; i < linha.length; i++) {
            System.out.print(linha[i] + " ");
        }

        sc.close();
    }
}
    
