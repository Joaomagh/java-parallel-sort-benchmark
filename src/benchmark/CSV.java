package benchmark;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import benchmark.Resultado;

public class CSV {
    public static void salvar(String nomeArquivoCSV, List<Resultado> resultados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivoCSV, true))) {
            File arquivo = new File(nomeArquivoCSV);

            // Escreve cabeçalho apenas se o arquivo estiver vazio
            if (arquivo.length() == 0) {
                writer.write("Algoritmo,Tamanho,Amostra,Tempo\n");
            }

            for (Resultado resultado : resultados) {
                writer.write(resultado.getAlgoritmo() + "," +
                        resultado.getTamanho() + "," +
                        resultado.getAmostra() + "," +
                        resultado.getTempo() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}