package utils;

public class Timer {
    private long inicio;
    private long fim;

    public void iniciar() {
        inicio = System.nanoTime();
    }

    public void parar() {
        fim = System.nanoTime();
    }

    public double getTempoSegundos() {
        return (fim - inicio) / 1_000_000_000.0;
    }
}
