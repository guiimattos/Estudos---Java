package Exercicios;

import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seu nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o valor da sua compra:");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite sua idade:");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Voce e estudante? true/false");
        boolean aluno = scanner.nextBoolean();

        double desconto = 0;

        if (valor >= 500) {
            desconto = 15;
        } else if (valor >= 200) {
            desconto = 10;
        } else if (aluno && idade < 18) {
            desconto = 5;
        } else {
            System.out.println("Nao tem desconto");
        }

        double valorDesconto = valor * desconto /100;
        double valorFinal = valor - valorDesconto;

        System.out.println("Nome do cliente:" + nome);
        System.out.println("Valor original: R$ " + valor);
        System.out.println("Desconto aplicado: R$ " + desconto + "%");
        System.out.println("Valor do desconto: R$" + valorFinal);

        scanner.close();
    }
}
