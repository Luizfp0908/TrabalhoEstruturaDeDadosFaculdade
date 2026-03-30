package Projeto3;

import java.util.Arrays;
import java.util.Random;

public class MainBenchmarkOrdenacao {

    public static void main(String[] args) {
        int[] volumes = {5000, 10000, 20000};
        int numExecucoes = 30;

        System.out.println("==================================================");
        System.out.println("   BENCHMARK DE ORDENAÇÃO (MERGE E QUICK SORT)    ");
        System.out.println("==================================================\n");

        for (int tamanho : volumes) {
            System.out.println(">>> Testando para VOLUME DE DADOS: " + tamanho);


            int[] arrayAleatorio = gerarArrayAleatorio(tamanho);
            int[] arrayOrdenado = gerarArrayOrdenado(tamanho);
            int[] arrayInvertido = gerarArrayInvertido(tamanho);


            double[] temposMergeAleatorio = new double[numExecucoes];
            double[] temposQuickAleatorio = new double[numExecucoes];

            double[] temposMergeOrdenado = new double[numExecucoes];
            double[] temposQuickOrdenado = new double[numExecucoes];

            double[] temposMergeInvertido = new double[numExecucoes];
            double[] temposQuickInvertido = new double[numExecucoes];

            for (int i = 0; i < numExecucoes; i++) {


                // CASO MÉDIO
                temposMergeAleatorio[i] = medirTempoMerge(Arrays.copyOf(arrayAleatorio, tamanho));
                temposQuickAleatorio[i] = medirTempoQuick(Arrays.copyOf(arrayAleatorio, tamanho));

                // MELHOR CASO
                temposMergeOrdenado[i] = medirTempoMerge(Arrays.copyOf(arrayOrdenado, tamanho));
                temposQuickOrdenado[i] = medirTempoQuick(Arrays.copyOf(arrayOrdenado, tamanho));

                // PIOR CASO
                temposMergeInvertido[i] = medirTempoMerge(Arrays.copyOf(arrayInvertido, tamanho));
                temposQuickInvertido[i] = medirTempoQuick(Arrays.copyOf(arrayInvertido, tamanho));
            }


            System.out.println("--- CASO MÉDIO (Dados Aleatórios) ---");
            System.out.printf("Merge Sort -> Média: %.4f ms | Desvio: %.4f ms\n", calcularMedia(temposMergeAleatorio), calcularDesvioPadrao(temposMergeAleatorio));
            System.out.printf("Quick Sort -> Média: %.4f ms | Desvio: %.4f ms\n\n", calcularMedia(temposQuickAleatorio), calcularDesvioPadrao(temposQuickAleatorio));

            System.out.println("--- MELHOR CASO (Dados Já Ordenados) ---");
            System.out.printf("Merge Sort -> Média: %.4f ms | Desvio: %.4f ms\n", calcularMedia(temposMergeOrdenado), calcularDesvioPadrao(temposMergeOrdenado));
            System.out.printf("Quick Sort -> Média: %.4f ms | Desvio: %.4f ms\n\n", calcularMedia(temposQuickOrdenado), calcularDesvioPadrao(temposQuickOrdenado));

            System.out.println("--- PIOR CASO (Dados Invertidos) ---");
            System.out.printf("Merge Sort -> Média: %.4f ms | Desvio: %.4f ms\n", calcularMedia(temposMergeInvertido), calcularDesvioPadrao(temposMergeInvertido));
            System.out.printf("Quick Sort -> Média: %.4f ms | Desvio: %.4f ms\n", calcularMedia(temposQuickInvertido), calcularDesvioPadrao(temposQuickInvertido));
            System.out.println("--------------------------------------------------\n");
        }
    }


    private static double medirTempoMerge(int[] array) {
        long inicio = System.nanoTime();
        AlgoritmosOrdenacao.mergeSort(array, 0, array.length - 1);
        long fim = System.nanoTime();
        return (fim - inicio) / 1_000_000.0;
    }

    private static double medirTempoQuick(int[] array) {
        long inicio = System.nanoTime();
        AlgoritmosOrdenacao.quickSort(array, 0, array.length - 1);
        long fim = System.nanoTime();
        return (fim - inicio) / 1_000_000.0;
    }


    private static int[] gerarArrayAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) array[i] = random.nextInt(tamanho * 10);
        return array;
    }

    private static int[] gerarArrayOrdenado(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) array[i] = i;
        return array;
    }

    private static int[] gerarArrayInvertido(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) array[i] = tamanho - i;
        return array;
    }


    public static double calcularMedia(double[] tempos) {
        double soma = 0;
        for (double t : tempos) soma += t;
        return soma / tempos.length;
    }

    public static double calcularDesvioPadrao(double[] tempos) {
        double media = calcularMedia(tempos);
        double somaDiferencasQuadrado = 0;
        for (double t : tempos) somaDiferencasQuadrado += Math.pow(t - media, 2);
        return Math.sqrt(somaDiferencasQuadrado / tempos.length);
    }
}