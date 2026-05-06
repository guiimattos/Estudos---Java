package Exercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Af {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // aceita ponto como separador decimal

        System.out.println("=== SISTEMA DE CALCULO DE NOTAS ===\n");
        executarCurlGet("https://jsonplaceholder.typicode.com/posts/1");

        // 1. Pesos das avaliações (AC1, AC2, AF, AG)
        double[] pesos = lerPesos(scanner);

        // 2. Nota mínima para aprovação
        double notaMinima = lerNotaMinima(scanner);

        // 3. Tamanho da turma
        int qtdAlunos = lerQuantidadeAlunos(scanner);

        // Estruturas para estatísticas
        double[] medias = new double[qtdAlunos];
        int aprovados = 0;
        int reprovados = 0;
        int recuperacao = 0;

        // 4. Notas dos alunos e 5. Resultado individual
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println("\n--- Aluno " + (i + 1) + " ---");

            double ac1 = lerNota(scanner, "AC1");
            double ac2 = lerNota(scanner, "AC2");
            double af  = lerNota(scanner, "AF");
            double ag  = lerNota(scanner, "AG");

            // Calcula a média ponderada (pesos em %)
            double media = (ac1 * pesos[0] + ac2 * pesos[1] + af * pesos[2] + ag * pesos[3]) / 100.0;
            medias[i] = media;

            System.out.printf("Media final do aluno %d: %.2f%n", (i + 1), media);

            // Determina situação
            String situacao;
            if (media >= notaMinima) {
                situacao = "Aprovado";
                aprovados++;
            } else if (Math.abs((notaMinima - media) - 1.0) < 1e-9) {
                // exatamente um ponto abaixo
                situacao = "Recuperacao";
                recuperacao++;
            } else if (media < notaMinima - 1.0) {
                situacao = "Reprovado";
                reprovados++;
            } else {
                // entre notaMinima-1 (exclusivo) e notaMinima (exclusivo)
                // Pelo enunciado: "exatamente um ponto abaixo" => recuperação,
                // "mais de um ponto abaixo" => reprovado.
                // Valores entre (notaMinima-1) e notaMinima caem aqui.
                // Interpretação coerente: como não está aprovado, e não está
                // mais de 1 ponto abaixo, classificamos como Recuperação.
                situacao = "Recuperacao";
                recuperacao++;
            }

            System.out.println("Situacao: " + situacao);

            // 6. Fluxo da turma
            if (i == qtdAlunos - 1) {
                System.out.println("\n*** Coleta de dados finalizada. ***");
            }
        }

        // 7. Estatísticas finais da turma
        double soma = 0.0;
        double maior = medias[0];
        double menor = medias[0];
        for (double m : medias) {
            soma += m;
            if (m > maior) maior = m;
            if (m < menor) menor = m;
        }
        double mediaTurma = soma / qtdAlunos;
        double pctAprovados   = (aprovados   * 100.0) / qtdAlunos;
        double pctReprovados  = (reprovados  * 100.0) / qtdAlunos;
        double pctRecuperacao = (recuperacao * 100.0) / qtdAlunos;

        System.out.println("\n=== ESTATISTICAS FINAIS DA TURMA ===");
        System.out.printf("Media final da turma: %.2f%n", mediaTurma);
        System.out.printf("Maior media final: %.2f%n", maior);
        System.out.printf("Menor media final: %.2f%n", menor);
        System.out.printf("Aprovados: %.2f%%%n", pctAprovados);
        System.out.printf("Reprovados: %.2f%%%n", pctReprovados);
        System.out.printf("Em recuperacao: %.2f%%%n", pctRecuperacao);

        scanner.close();
    }

    // ===== Métodos auxiliares =====

    /** Executa um curl GET simples e imprime a resposta no console. */
    private static void executarCurlGet(String url) {
        ProcessBuilder processBuilder = new ProcessBuilder("curl", "-s", "-X", "GET", url);

        try {
            Process processo = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
                String linha;
                System.out.println("Resposta do GET:");
                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }
                System.out.println();
            }

            int codigoSaida = processo.waitFor();
            if (codigoSaida != 0) {
                System.out.println("Erro ao executar curl. Codigo de saida: " + codigoSaida);
            }
        } catch (IOException e) {
            System.out.println("Nao foi possivel executar o curl GET: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Execucao do curl GET interrompida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Lê os 4 pesos (AC1, AC2, AF, AG). A soma deve ser 100.
     * Caso contrário, descarta tudo e pede novamente.
     */
    private static double[] lerPesos(Scanner scanner) {
        double[] pesos = new double[4];
        String[] nomes = {"AC1", "AC2", "AF", "AG"};

        while (true) {
            System.out.println("Informe os pesos das avaliacoes (em %, somente o numero).");
            double soma = 0.0;
            for (int i = 0; i < 4; i++) {
                double valor = lerDoubleNaoNegativo(scanner, "Peso de " + nomes[i] + ": ");
                pesos[i] = valor;
                soma += valor;
            }

            if (Math.abs(soma - 100.0) < 1e-9) {
                System.out.println("Pesos validos! Soma = 100%.\n");
                return pesos;
            } else {
                System.out.printf("Soma dos pesos = %.2f%%. A soma deve ser exatamente 100%%. Informe os 4 pesos novamente.%n%n", soma);
            }
        }
    }

    /** Lê a nota mínima de aprovação (entre 0 e 10). */
    private static double lerNotaMinima(Scanner scanner) {
        while (true) {
            double valor = lerDouble(scanner, "Informe a nota minima para aprovacao (0 a 10): ");
            if (valor >= 0.0 && valor <= 10.0) {
                System.out.println();
                return valor;
            }
            System.out.println("Valor invalido. A nota minima deve estar entre 0 e 10.");
        }
    }

    /** Lê a quantidade de alunos (inteiro positivo). */
    private static int lerQuantidadeAlunos(Scanner scanner) {
        while (true) {
            System.out.print("Informe a quantidade de alunos da turma: ");
            String linha = scanner.nextLine().trim().replace(",", ".");
            try {
                int valor = Integer.parseInt(linha);
                if (valor > 0) {
                    System.out.println();
                    return valor;
                }
                System.out.println("Valor invalido. A quantidade de alunos deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro positivo.");
            }
        }
    }

    /** Lê uma nota (entre 0 e 10) para uma avaliação específica. */
    private static double lerNota(Scanner scanner, String nomeAvaliacao) {
        while (true) {
            double valor = lerDouble(scanner, "Nota " + nomeAvaliacao + " (0 a 10): ");
            if (valor >= 0.0 && valor <= 10.0) {
                return valor;
            }
            System.out.println("Valor invalido. A nota deve estar entre 0 e 10.");
        }
    }

    /** Lê um double com tratamento de erro. */
    private static double lerDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = scanner.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero (ex: 7.5).");
            }
        }
    }

    /** Lê um double não negativo. */
    private static double lerDoubleNaoNegativo(Scanner scanner, String prompt) {
        while (true) {
            double valor = lerDouble(scanner, prompt);
            if (valor >= 0.0) {
                return valor;
            }
            System.out.println("Valor invalido. Informe um numero maior ou igual a zero.");
        }
    }
}
