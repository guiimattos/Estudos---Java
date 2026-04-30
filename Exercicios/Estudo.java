package Exercicios;

import java.util.Scanner;

public class Estudo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o seu nome:");
        String name = scanner.nextLine();
        
        System.out.println("Coloque sua primeira nota:");
        double nota1 = scanner.nextDouble();

        System.out.println("Coloque sua segunda nota:");
        double nota2 = scanner.nextDouble();

        System.out.println("Coloque sua terceira nota:");
        double nota3 = scanner.nextDouble();

        System.out.println("Coloque sua quarta nota:");
        double nota4 = scanner.nextDouble();

        double resultado = (nota1 + nota2 + nota3 + nota4) /3;
        System.out.println("a sua média das notas é: " + resultado);

        if (resultado >= 7) {
            System.out.println("Aprovado");
        }
        else{
            System.out.println("Você está abaixo da média, você está reprovado!!");
        }

        scanner.close();
    }
}
