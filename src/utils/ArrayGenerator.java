package utils;

import java.util.Random;

public class ArrayGenerator {
    public static int[] gerarArrayAleatorio(int tamanho, int maxValor) {
        Random random = new Random();
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(maxValor);
        }
        return array;
    }
}
