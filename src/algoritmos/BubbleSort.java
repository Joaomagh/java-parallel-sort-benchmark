package algoritmos;

public class BubbleSort implements Algoritmo {

    @Override
    public void ordenar(int[] array) {
        int n = array.length;
        boolean trocou;
        do {
            trocou = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    trocou = true;
                }
            }
            n--;
        } while (trocou);
    }

    @Override
    public String getNome() {
        return "BubbleSort";
    }
}