package Exercicios;

import java.util.Scanner;

public class Estudo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao = -1;
        double total = 0;

        while (opcao != 0) {
            System.out.println("Máquina de Vendas");
            System.out.println("1 - Refrigerante - R$ 5.00");
            System.out.println("2 - Salgado - R$ 7.00");
            System.out.println("3 - Chocolate - R$ 4.00");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção");

            opcao = sc.nextInt();

            if (opcao == 1) {
                total = total + 5.00;
                System.out.println("Refrigerante adicionado!");
            } else if (opcao == 2) {
                total = total + 7.00;
                System.out.println("Salgado adicionado!");
            } else if (opcao == 3) {
                total = total + 4.00;
                System.out.println("Chocolate adicionado!");
                
            } else if (opcao == 0) {
                System.out.println("Finalizado!");
            }
        }

        System.out.println("Total da compra: R$" + total);


        sc.close();
    }
}
