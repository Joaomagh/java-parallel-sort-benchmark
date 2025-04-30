package paralelo;
import algoritmos.Algoritmo;

public class ParaleloBubbleSort implements Algoritmo {
    private final int numThreads;

    public ParaleloBubbleSort(int numThreads) {
        this.numThreads = numThreads;
    }

    @Override
    public void ordenar(int[] array) {
        Thread[] threads = new Thread[numThreads];
        int n = array.length;

        for (int t = 0; t < numThreads; t++) {
            final int threadIndex = t;
            threads[t] = new Thread(() -> {
                for (int i = threadIndex; i < n - 1; i += numThreads) {
                    for (int j = 0; j < n - i - 1; j++) {
                        synchronized (array) {
                            if (array[j] > array[j + 1]) {
                                int temp = array[j];
                                array[j] = array[j + 1];
                                array[j + 1] = temp;
                            }
                        }
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
    }

    @Override
    public String getNome() {
        return "Paralelo Bubble Sort (" + numThreads + " threads)";
    }
}