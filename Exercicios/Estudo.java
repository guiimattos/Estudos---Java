package Exercicios;

import java.util.Scanner;

public class Estudo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o seu nome:");
        String nome = scanner.nextLine();
        
        System.out.println("Coloque sua primeira nota:");
        double nota1 = scanner.nextDouble();

        System.out.println("Coloque sua segunda nota:");
        double nota2 = scanner.nextDouble();

        System.out.println("Coloque sua terceira nota:");
        double nota3 = scanner.nextDouble();

        double resultado = (nota1 + nota2 + nota3) /3;
        System.out.println("A sua media das notas e: " + resultado);

        if (resultado >= 7) {
            System.out.println("Aprovado");
        }
        else{
            System.out.println("Voce esta abaixo da media, voce esta reprovado!");
        }

        scanner.close();
    }
}
