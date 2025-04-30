package algoritmos;

public class QuickSort implements Algoritmo {

    @Override
    public void ordenar(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(array, inicio, fim);
            quickSort(array, inicio, pivoIndex - 1);
            quickSort(array, pivoIndex + 1, fim);
        }
    }

    private int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivo) {
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

    @Override
    public String getNome() {
        return "QuickSort";
    }
}