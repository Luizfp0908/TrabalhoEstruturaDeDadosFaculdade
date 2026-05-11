package WarRoom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Encontrar {
    private Grafo grafo;
    private int tamanhoMinimo;
    private List<Integer> melhorCobertura;

    public Encontrar(Grafo grafo) {
        this.grafo = grafo;
        this.tamanhoMinimo = grafo.getTotalVertices() + 1;
        this.melhorCobertura = new ArrayList<>();
    }

    public List<Integer> calcularCoberturaMinima() {
        buscar(0, new ArrayList<>());
        return melhorCobertura;
    }

    private void buscar(int v, List<Integer> coberturaAtual) {
        if (coberturaAtual.size() >= tamanhoMinimo) {
            return;
        }

        if (v == grafo.getTotalVertices()) {
            if (coberturaValida(coberturaAtual)) {
                tamanhoMinimo = coberturaAtual.size();
                melhorCobertura = new ArrayList<>(coberturaAtual);
            }
            return;
        }

        coberturaAtual.add(v);
        buscar(v + 1, coberturaAtual);

        coberturaAtual.remove(coberturaAtual.size() - 1);
        buscar(v + 1, coberturaAtual);
    }

    private boolean coberturaValida(List<Integer> cobertura) {
        Set<Integer> conjunto = new HashSet<>(cobertura);
        for (Aresta aresta : grafo.getArestas()) {
            if (!conjunto.contains(aresta.getOrigem()) && !conjunto.contains(aresta.getDestino())) {
                return false;
            }
        }
        return true;
    }
}
