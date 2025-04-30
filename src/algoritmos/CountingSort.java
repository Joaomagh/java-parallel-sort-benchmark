package algoritmos;

public class CountingSort implements Algoritmo {

    @Override
    public void ordenar(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) max = num;
        }

        int[] count = new int[max + 1];
        for (int num : array) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                array[index++] = i;
            }
        }
    }

    @Override
    public String getNome() {
        return "CountingSort";
    }
}