package paralelo;

import algoritmos.Algoritmo;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class ParaleloQuickSort implements Algoritmo {
    private final int threads;

    public ParaleloQuickSort(int threads) {
        this.threads = threads;
    }

    @Override
    public void ordenar(int[] array) {
        ForkJoinPool pool = new ForkJoinPool(threads);
        pool.invoke(new QuickSortTask(array, 0, array.length - 1));
    }

    @Override
    public String getNome() {
        return "Paralelo Quick Sort";
    }

    private static class QuickSortTask extends RecursiveAction {
        private final int[] array;
        private final int low, high;

        QuickSortTask(int[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                invokeAll(
                        new QuickSortTask(array, low, pivotIndex - 1),
                        new QuickSortTask(array, pivotIndex + 1, high)
                );
            }
        }

        private int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (array[j] <= pivot) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, high);
            return i + 1;
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
