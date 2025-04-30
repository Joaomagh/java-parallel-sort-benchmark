package algoritmos;

public interface Algoritmo {
    void ordenar(int[] array);
    String getNome(); // opcional, útil para logs/benchmark
}