package benchmark;

import algoritmos.Algoritmo;
import utils.ArrayGenerator;
import utils.Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BenchmarkRunner {
    private static final int[] tamanhos = {10_000, 50_000, 100_000};
    private static final int AMOSTRAS = 5;
    private static final int MAX_VALOR = 1_000_000;

    public static void executarTestes(List<Algoritmo> algoritmos, String nomeArquivoCSV) {
        List<Resultado> resultados = new ArrayList<>(); // Criando lista de resultados

        for (int tamanho : tamanhos) {
            for (Algoritmo algoritmo : algoritmos) {
                for (int i = 0; i < AMOSTRAS; i++) {
                    int[] array = ArrayGenerator.gerarArrayAleatorio(tamanho, MAX_VALOR);
                    int[] copia = Arrays.copyOf(array, array.length);

                    Timer timer = new Timer();
                    timer.iniciar();
                    algoritmo.ordenar(copia);
                    timer.parar();

                    double tempo = timer.getTempoSegundos();  // ou long tempo = timer.getTempoMilissegundos();
                    Resultado resultado = new Resultado(algoritmo.getNome(), tamanho, i + 1, tempo);
                    resultados.add(resultado); // Adiciona à lista
                }
            }
        }

        CSV.salvar(nomeArquivoCSV, resultados); // Salva todos os resultados no final
    }
}
