package Exercicios;

import java.util.Scanner;

public class While2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;

        System.out.println("Digite um numero inteiro");
        numero = sc.nextInt();

        int soma = 0;
        int quantidade = 0;

        while (numero != 0) {
            soma = soma + numero;
            quantidade = quantidade + 1;

            System.out.println("Continue tentando");
            System.out.println("Digite outro numero inteiro");
            numero = sc.nextInt();
        }

        System.out.println("Soma: " + soma);
        System.out.println("Quantidade de numeros digitados: " + quantidade);

        sc.close();
    }
}
