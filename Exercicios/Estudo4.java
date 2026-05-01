package Exercicios;

import java.util.Scanner;

public class Estudo4 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int numero;
        int digitados = 0;
        int soma = 0;
        double media = 0;

        System.out.println("Digite um número: ");
        numero = sc.nextInt();

        while (numero != 0) {
            soma = soma + numero;
            digitados++;

            System.out.println("Digite um número: ");
            numero = sc.nextInt();
        }

        if (digitados > 0) {
            media = (double) soma / digitados;

            System.out.println("Soma total: " + soma);
            System.out.println("Quantidade de números: " + digitados);
            System.out.println("Média: " + media);
        } else {
            System.out.println("Nenhum número foi digitado.");
        }

        sc.close();
    }
}
