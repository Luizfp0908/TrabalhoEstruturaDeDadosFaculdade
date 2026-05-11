package Projeto3;

public class AlgoritmosOrdenacao {


    public static void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            merge(array, inicio, meio, fim);
        }
    }

    private static void merge(int[] array, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];


        for (int i = 0; i < n1; ++i) esquerda[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j) direita[j] = array[meio + 1 + j];

        int i = 0, j = 0;
        int k = inicio;


        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }
            k++;
        }

        // Copia o resto (se sobrar)
        while (i < n1) {
            array[k] = esquerda[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = direita[j];
            j++;
            k++;
        }
    }


    public static void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {

            int indicePivo = particionar(array, inicio, fim);


            quickSort(array, inicio, indicePivo - 1);
            quickSort(array, indicePivo + 1, fim);
        }
    }

    private static int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {

            if (array[j] < pivo) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }


        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1;
    }
}