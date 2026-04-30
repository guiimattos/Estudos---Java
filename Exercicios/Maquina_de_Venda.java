package Exercicios;

import java.util.Scanner;

public class Maquina_de_Venda {
    // Faça um algoritmo que simula uma máquina de venda automática.
    // O usuário deve escolher o produto desejado.
    // Inserir o valor do pagamento até que o pagamento seja suficiente.
    // O algoritmo deve mostrar o troco a ser devolvido ao usuário.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] produto = {"Pastel", "Salgado", "Caldo de Cana", "Suco Natural", "Refrigerante"};
        double[] precos = {12.0, 10.50, 7.0, 7.50, 6.0};

        int opcao;
        int indiceProduto;
        double valorProduto;
        double valorPago = 0;
        double troco;

        System.out.println("Escolha um produto:");

        for (int i = 0; i < produto.length; i++) {
            System.out.println((i + 1) + " - " + produto[i] + " | R$ " + precos[i]);
        }

        opcao = sc.nextInt();

        if (opcao < 1 || opcao > produto.length) {
            System.out.println("Opção inválida!");
            sc.close();
            return;
        }

        indiceProduto = opcao - 1;
        valorProduto = precos[indiceProduto];

        while (valorPago < valorProduto) {
            System.out.println("Digite o valor do pagamento:");
            valorPago += sc.nextDouble();
        }

        troco = valorPago - valorProduto;

        System.out.println("Produto escolhido: " + produto[indiceProduto]);
        System.out.println("O troco a ser devolvido é: R$ " + troco);

        sc.close();
    }
}
