# Estruturas, Pesquisa e Ordenação de Dados 🌳🔍📊

Repositório destinado aos projetos práticos da avaliação bimestral da disciplina de **Estruturas, Pesquisa e Ordenação de Dados** do curso de Engenharia de Software (5º Semestre) da Unicesumar (Ponta Grossa/PR).

## 👥 Integrantes do Grupo
* **Luiz Francisco P. P. Neto**
* **Camilli Vitória de Lara**
* **Gabriel F. Palomares**

O foco deste projeto é a implementação em **Java** de estruturas de dados complexas e a análise estatística de desempenho (tempo de execução e complexidade) em diferentes volumes de dados, simulando cenários reais de backend.

📄 **Nota:** O relatório completo com a análise estatística, gráficos de desempenho e conclusões teóricas (Big-O) está disponível no arquivo `Relatorio_EstruturaDeDados.pdf` anexado a este repositório.

## 🚀 Estrutura dos Projetos

O trabalho está dividido em quatro módulos principais:

### 1. Projeto War Room: Cobertura de Vértices (Vertex Cover)
Simulação de uma central de resposta a incidentes (War Room) para analisar uma rede de infraestrutura crítica sob ataque.
*   **Problema:** Encontrar o menor conjunto de vértices capaz de cobrir todas as arestas do grafo (Vertex Cover).
*   **Complexidade:** Trata-se de um problema **NP-Completo**. A solução utiliza **Backtracking** para garantir a cobertura mínima absoluta.
*   **Implementação:** Organizado sob o padrão de pacotes (`package war`) e Programação Orientada a Objetos para garantir modularidade e separação de responsabilidades entre os componentes do grafo e o motor de otimização.

### 2. Projeto 1: Árvores e Balanceamento
Implementação das operações fundamentais (Inserção, Remoção, Busca e Cálculo de Altura) em três tipos de árvores binárias para avaliar o custo do balanceamento:
* **Árvore Binária de Busca (BST):** Estrutura base sem auto-balanceamento.
* **Árvore AVL:** Balanceamento rigoroso baseado em fator de equilíbrio (altura).
* **Árvore Rubro-Negra (Red-Black Tree):** Balanceamento otimizado focado em propriedades de coloração de nós.
* **Heurística do Caixeiro-Viajante:** Algoritmo do Vizinho Mais Próximo implementado para solucionar o problema em grafos (matriz de adjacência) com análise de tempo.

### 3. Projeto 2: Sistemas de Busca
Benchmark comparativo entre algoritmos de pesquisa utilizando diferentes volumes de dados (10k, 100k e 1M de registros):
* Busca Sequencial ($O(n)$)
* Busca Binária ($O(\log n)$)
* Busca em Árvore de Busca AVL ($O(\log n)$)

### 4. Projeto 3: Benchmark de Ordenação
Análise empírica e teórica dos algoritmos de ordenação mais utilizados no mercado, avaliando o Melhor Caso, Caso Médio e Pior Caso em arrays de até 20.000 posições:
* Merge Sort ($O(n \log n)$)
* Quick Sort ($O(n \log n)$ a $O(n^2)$)

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java
* **Conceitos:** Orientação a Objetos, Grafos, Recursão, Análise de Complexidade de Algoritmos (Big-O), Estatística Básica.

## ⚙️ Como Executar
1. Clone este repositório:
   ```bash
   git clone [https://github.com/Luizfp0908/TrabalhoEstruturaDeDadosFaculdade.git](https://github.com/Luizfp0908/TrabalhoEstruturaDeDadosFaculdade.git)
