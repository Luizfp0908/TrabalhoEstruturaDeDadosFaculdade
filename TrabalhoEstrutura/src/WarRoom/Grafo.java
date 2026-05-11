package WarRoom;


import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private int totalVertices;
    private List<Aresta> arestas;

    public Grafo(int totalVertices) {
        this.totalVertices = totalVertices;
        this.arestas = new ArrayList<>();
    }

    public void adicionarAresta(int origem, int destino) {
        arestas.add(new Aresta(origem, destino));
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }
}
