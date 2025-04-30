package benchmark;

public class Resultado {
    private final String algoritmo;
    private final int tamanho;
    private final int amostra;
    private final double tempo;

    public Resultado(String algoritmo, int tamanho, int amostra, double tempo) {
        this.algoritmo = algoritmo;
        this.tamanho = tamanho;
        this.amostra = amostra;
        this.tempo = tempo;
    }

    public String toCSV() {
        return String.format("%s,%d,%d,%.6f\n", algoritmo, tamanho, amostra, tempo);
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getAmostra() {
        return amostra;
    }

    public double getTempo() {
        return tempo;
    }
}

