# Estruturas, Pesquisa e Ordenação de Dados 🌳🔍📊

Repositório destinado aos projetos práticos da disciplina de **Estruturas de Dados II** do curso de Engenharia de Software (5º Semestre) da Unicesumar - Ponta Grossa/PR.

## 👥 Integrantes do Grupo
* **Luiz Francisco P. P. Neto**
* **Camilli Vitória de Lara**
* **Gabriel F. Palomares**

## 🚀 Módulos do Projeto

O trabalho engloba a implementação de algoritmos clássicos com foco em performance e organização de código:

### 1. War Room: Simulação de Vertex Cover (Grafos)
Este módulo resolve o desafio de infraestrutura crítica proposto em aula. O objetivo é encontrar o **Menor Conjunto de Vértices** (Vertex Cover) que cubra todas as arestas de um grafo, simulando o monitoramento de servidores em um ataque cibernético.

*   **Abordagem Técnica:** O problema de Vertex Cover é **NP-Completo**. Implementamos uma solução utilizando **Backtracking com Poda (Pruning)**. O algoritmo explora as combinações de vértices e descarta caminhos que já ultrapassaram o tamanho da melhor solução encontrada até o momento.
*   **Complexidade:** $O(2^V \cdot E)$ no pior caso.
*   **Arquitetura:** O projeto foi desenvolvido seguindo os princípios de **Programação Orientada a Objetos (POO)** e organizado no pacote `war`, separando as responsabilidades entre classes de modelo (`Grafo`, `Aresta`) e classes de lógica (`Otimizador`, `Encontrar`).

### 2. Árvores e Balanceamento
Análise do custo de balanceamento e operações em estruturas não lineares:
*   **BST, AVL e Rubro-Negra:** Comparativo de altura e tempo de inserção/busca.
*   **Caixeiro-Viajante:** Algoritmo do Vizinho Mais Próximo para otimização de rotas em grafos.

### 3. Sistemas de Busca e Ordenação
Benchmark comparativo entre diferentes algoritmos:
*   **Busca:** Sequencial, Binária e AVL.
*   **Ordenação:** Merge Sort e Quick Sort, testados com volumes de até 1 milhão de registros para análise de Big-O.

## 🛠️ Por que escolhemos essa implementação?

Para o módulo **War Room**, optamos por uma estrutura **Orientada a Objetos com Pacotes** por três motivos principais:
1.  **Escalabilidade:** A separação em classes (`Grafo`, `Aresta`, `Encontrar`) permite que o código seja reutilizado em outros projetos de backend sem necessidade de reescrita.
2.  **Manutenibilidade:** Facilitar a leitura e correção de bugs específicos em partes isoladas do algoritmo.
3.  **Encapsulamento:** Garantir que os dados do grafo não sejam alterados de forma insegura durante o processamento da cobertura mínima.

## ⚙️ Como Executar

1.  Clone este repositório:
    ```bash
    git clone [https://github.com/Luizfp0908/TrabalhoEstruturaDeDadosFaculdade.git](https://github.com/Luizfp0908/TrabalhoEstruturaDeDadosFaculdade.git)
