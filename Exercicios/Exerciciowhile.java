package Exercicios;

import java.util.Scanner;

public class Exerciciowhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int valorRecebido = 0;
        int soma = 0;

        while (valorRecebido >= 0) {
            System.out.println("Digite o valor ou um numero negativo para sair: ");
            valorRecebido = scanner.nextInt();

            if (valorRecebido >= 0) {
                soma += valorRecebido;
            }
        }

        System.out.println("A soma dos valores digitados é: " + soma);

        scanner.close();
    }
}
