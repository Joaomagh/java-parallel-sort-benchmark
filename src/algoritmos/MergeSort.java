package algoritmos;

public class MergeSort implements Algoritmo {

    @Override
    public void ordenar(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            merge(array, inicio, meio, fim);
        }
    }

    private void merge(int[] array, int inicio, int meio, int fim) {
        int[] temp = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= meio) temp[k++] = array[i++];
        while (j <= fim) temp[k++] = array[j++];

        System.arraycopy(temp, 0, array, inicio, temp.length);
    }

    @Override
    public String getNome() {
        return "MergeSort";
    }
}