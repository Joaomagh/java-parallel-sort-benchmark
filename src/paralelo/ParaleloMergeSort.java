package paralelo;

import algoritmos.Algoritmo;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class ParaleloMergeSort implements Algoritmo {
    @Override
    public void ordenar(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortTask(array, 0, array.length - 1));
    }

    @Override
    public String getNome() {
        return "Paralelo Merge Sort";
    }

    private static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int left, right;

        MergeSortTask(int[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (left < right) {
                int mid = (left + right) / 2;
                invokeAll(new MergeSortTask(array, left, mid),
                        new MergeSortTask(array, mid + 1, right));
                merge(array, left, mid, right);
            }
        }

        private void merge(int[] array, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = left, j = mid + 1, k = 0;

            while (i <= mid && j <= right) {
                temp[k++] = (array[i] <= array[j]) ? array[i++] : array[j++];
            }
            while (i <= mid) temp[k++] = array[i++];
            while (j <= right) temp[k++] = array[j++];

            System.arraycopy(temp, 0, array, left, temp.length);
        }
    }
}
