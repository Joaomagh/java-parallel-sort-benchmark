import algoritmos.*;
import paralelo.*;
import benchmark.BenchmarkRunner;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Algoritmo> algoritmosSequenciais = List.of(
                new BubbleSort(),
                new CountingSort(),
                new MergeSort(),
                new QuickSort()
        );

        List<Algoritmo> algoritmosParalelos = List.of(
                new ParaleloBubbleSort(4),
                new ParaleloCountingSort(4),
                new ParaleloMergeSort(),
                new ParaleloQuickSort(4)
        );

        BenchmarkRunner.executarTestes(algoritmosSequenciais, "resultados_sequenciais.csv");
        BenchmarkRunner.executarTestes(algoritmosParalelos, "resultados_paralelos.csv");
    }
}