package Projeto2;

import Projeto1.Avl; // Importando a árvore do Projeto 1

public class MainBenchmarkBusca {

    public static void main(String[] args) {

        int[] volumes = {10000, 100000, 1000000};
        int numExecucoes = 30;

        System.out.println("==================================================");
        System.out.println("   BENCHMARK DE BUSCAS E ANÁLISE ESTATÍSTICA      ");
        System.out.println("==================================================\n");

        for (int tamanho : volumes) {
            System.out.println(">>> Testando para VOLUME DE DADOS: " + tamanho);

            int[] array = new int[tamanho];
            Avl arvore = new Avl();

            for (int i = 0; i < tamanho; i++) {
                array[i] = i;
                arvore.inserir(i);
            }

            int alvo = tamanho + 1;

            double[] temposSequencial = new double[numExecucoes];
            double[] temposBinaria = new double[numExecucoes];
            double[] temposArvore = new double[numExecucoes];

            for (int i = 0; i < numExecucoes; i++) {
                long inicio, fim;


                inicio = System.nanoTime();
                SistemasDeBusca.buscaSequencial(array, alvo);
                fim = System.nanoTime();
                temposSequencial[i] = (fim - inicio);


                inicio = System.nanoTime();
                SistemasDeBusca.buscaBinaria(array, alvo);
                fim = System.nanoTime();
                temposBinaria[i] = (fim - inicio);


                inicio = System.nanoTime();
                arvore.buscar(alvo);
                fim = System.nanoTime();
                temposArvore[i] = (fim - inicio);
            }

            System.out.println("--- Busca Sequencial ---");
            System.out.printf("Média: %.2f ns | Desvio Padrão: %.2f ns\n", calcularMedia(temposSequencial), calcularDesvioPadrao(temposSequencial));

            System.out.println("--- Busca Binária ---");
            System.out.printf("Média: %.2f ns | Desvio Padrão: %.2f ns\n", calcularMedia(temposBinaria), calcularDesvioPadrao(temposBinaria));

            System.out.println("--- Busca em Árvore (AVL) ---");
            System.out.printf("Média: %.2f ns | Desvio Padrão: %.2f ns\n\n", calcularMedia(temposArvore), calcularDesvioPadrao(temposArvore));
        }
    }


    public static double calcularMedia(double[] tempos) {
        double soma = 0;
        for (double t : tempos) {
            soma += t;
        }
        return soma / tempos.length;
    }

    public static double calcularDesvioPadrao(double[] tempos) {
        double media = calcularMedia(tempos);
        double somaDiferencasQuadrado = 0;
        for (double t : tempos) {
            somaDiferencasQuadrado += Math.pow(t - media, 2);
        }
        double variancia = somaDiferencasQuadrado / tempos.length;
        return Math.sqrt(variancia);
    }
}