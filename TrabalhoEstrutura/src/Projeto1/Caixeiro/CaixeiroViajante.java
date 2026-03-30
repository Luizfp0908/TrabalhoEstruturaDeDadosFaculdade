package Projeto1.Caixeiro;

import java.util.Random;

public class CaixeiroViajante {


    public static int vizinhoMaisProximo(int[][] grafo) {
        int n = grafo.length;
        boolean[] visitado = new boolean[n];

        visitado[0] = true;
        int cidadeAtual = 0;
        int distanciaTotal = 0;
        int cidadesVisitadas = 1;

        while (cidadesVisitadas < n) {
            int proximaCidade = -1;
            int menorDistancia = Integer.MAX_VALUE;


            for (int i = 0; i < n; i++) {
                if (!visitado[i] && grafo[cidadeAtual][i] > 0 && grafo[cidadeAtual][i] < menorDistancia) {
                    menorDistancia = grafo[cidadeAtual][i];
                    proximaCidade = i;
                }
            }


            visitado[proximaCidade] = true;
            distanciaTotal += menorDistancia;
            cidadeAtual = proximaCidade;
            cidadesVisitadas++;
        }


        distanciaTotal += grafo[cidadeAtual][0];

        return distanciaTotal;
    }


    public static int[][] gerarGrafoAleatorio(int tamanho) {
        int[][] grafo = new int[tamanho][tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (i == j) {
                    grafo[i][j] = 0;
                } else if (grafo[i][j] == 0) {

                    int distancia = random.nextInt(100) + 1;
                    grafo[i][j] = distancia;
                    grafo[j][i] = distancia;
                }
            }
        }
        return grafo;
    }


    public static void main(String[] args) {
        int[] tamanhos = {500, 1000, 2000};
        int numExecucoes = 5;

        System.out.println("Iniciando Experimentos do Caixeiro-Viajante...\n");

        for (int tamanho : tamanhos) {
            System.out.println("Tamanho do Grafo: " + tamanho + " cidades");
            long[] tempos = new long[numExecucoes];

            for (int i = 0; i < numExecucoes; i++) {
                int[][] grafo = gerarGrafoAleatorio(tamanho);


                long inicio = System.nanoTime();


                vizinhoMaisProximo(grafo);


                long fim = System.nanoTime();

                tempos[i] = (fim - inicio);


                System.out.println("Tempos das 5 execucoes (em nanosegundos):");
                for (long t : tempos) {
                    System.out.println(t);
                }
                System.out.println("--------------------------------------------------");
            }
        }
    }
}
