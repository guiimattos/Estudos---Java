package Exercicios;

import java.util.Scanner;

public class Estudo2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número");
        int numero = sc.nextInt();

        for (int i = 1; i <= numero; i++) {
            int multiplicacao= numero * i;

            System.out.println(numero + " x " + i + " = " + multiplicacao);
        }
    
        sc.close();

    }
}
