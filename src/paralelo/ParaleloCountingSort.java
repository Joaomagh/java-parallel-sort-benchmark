package paralelo;

import algoritmos.Algoritmo;

import java.util.Arrays;

public class ParaleloCountingSort implements Algoritmo {
    private final int numThreads;

    public ParaleloCountingSort(int numThreads) {
        this.numThreads = numThreads;
    }

    @Override
    public void ordenar(int[] array) {
        if (array.length == 0) return;

        int max = Arrays.stream(array).max().orElse(0);
        int[] count = new int[max + 1];

        // contagem paralela
        Thread[] threads = new Thread[numThreads];
        int chunk = array.length / numThreads;

        for (int t = 0; t < numThreads; t++) {
            final int start = t * chunk;
            final int end = (t == numThreads - 1) ? array.length : start + chunk;

            threads[t] = new Thread(() -> {
                for (int i = start; i < end; i++) {
                    synchronized (count) {
                        count[array[i]]++;
                    }
                }
            });
            threads[t].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {}
        }

        // reconstruir array
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                array[idx++] = i;
            }
        }
    }

    @Override
    public String getNome() {
        return "Paralelo Counting Sort (" + numThreads + " threads)";
    }
}