# Benchmark de Algoritmos de Ordenação em Java: Versões Sequenciais vs Paralelas

Este projeto tem como objetivo analisar e comparar o desempenho de algoritmos clássicos de ordenação, implementados em Java nas versões sequenciais e paralelas. O foco é aplicar conceitos de computação concorrente e paralela para observar como diferentes abordagens se comportam em cenários variados de entrada e configuração de hardware.

## Objetivos

- Implementar algoritmos de ordenação em versões sequenciais e paralelas.
- Realizar benchmarks com diferentes tamanhos e naturezas de dados de entrada.
- Variar a quantidade de threads nas versões paralelas.
- Executar cada cenário múltiplas vezes para obter médias confiáveis.
- Armazenar os resultados em arquivos CSV para análise posterior.
- Gerar gráficos e realizar análise comparativa de desempenho.

## Algoritmos Implementados

| Algoritmo       | Versão Sequencial | Versão Paralela |
|-----------------|-------------------|------------------|
| Bubble Sort     | Sim               | Sim (threads)    |
| Merge Sort      | Sim               | Sim (ForkJoin)   |
| Quick Sort      | Sim               | Sim (ForkJoin)   |
| Counting Sort   | Sim               | Sim (threads)    |

## Metodologia

- Implementações concorrentes com Java Threads e ForkJoinPool.
- Criação de um framework de testes automatizado com registro dos tempos de execução.
- Cada execução é repetida pelo menos 5 vezes para melhor precisão estatística.
- Execuções realizadas com diferentes tamanhos de entrada e diferentes números de threads.
- Comportamento dos algoritmos avaliado em diferentes quantidades de núcleos da CPU.

## Estrutura do Projeto

projeto/ 
-  ├── algoritmos/ 
-  ├── paralelo/ 
-  ├── benchmark/  
-  ├── utils/ 
-  ├── resultados.csv 
- └── README.md # Documentação do projeto

## Como Executar

1. Clone o repositório:
git clone https://github.com/seu-usuario/java-parallel-sort-benchmark.git cd java-parallel-sort-benchmark

2. Compile os arquivos Java:

3. Execute os testes de benchmark:
java -cp out benchmark.BenchmarkRunner

4. Os resultados serão armazenados no arquivo `resultados.csv`.

## Resultados Esperados

Espera-se compreender o desempenho relativo dos algoritmos sob diferentes condições de entrada e configuração de execução (número de núcleos). Os resultados obtidos contribuirão com análises mais profundas sobre qual abordagem é mais vantajosa em cada cenário, e servirão como base para projetos futuros que envolvam computação paralela e otimização de desempenho.

## Próximos Passos

- Automatizar a geração de gráficos bibliotecas Java.
- Criar uma interface gráfica para facilitar a execução e visualização


**João Pedro Rego Magalhães**  
Estudante de Ciência da Computação | Desenvolvedor Java Backend  
[LinkedIn](https://www.linkedin.com/in/joaomagh) • [GitHub](https://github.com/Joaomagh)

Integrantes: João Pedro Rego, Bruno Matos
