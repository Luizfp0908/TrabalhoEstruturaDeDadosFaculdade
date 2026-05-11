package WarRoom;

import WarRoom.Grafo;
import WarRoom.Otimizar;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número de vértices:");
        int totalVertices = sc.nextInt();
        Grafo grafo = new Grafo(totalVertices);

        System.out.println("Digite o número de arestas:");
        int totalArestas = sc.nextInt();

        System.out.println("Digite os pares de vértices que formam as arestas (ex: 0 1):");
        for (int i = 0; i < totalArestas; i++) {
            grafo.adicionarAresta(sc.nextInt(), sc.nextInt());
        }

        Otimizar otimizador = new Otimizar();
        List<Integer> resultado = otimizador.resolver(grafo);

        System.out.println("\n--- RESULTADO WAR ROOM ---");
        System.out.println("Vértices escolhidos: " + resultado);
        System.out.println("Tamanho da cobertura: " + resultado.size());
        System.out.println("Análise de Complexidade: O(2^V * E) - Complexidade Exponencial no pior caso (Backtracking exato).");

        sc.close();
    }
}