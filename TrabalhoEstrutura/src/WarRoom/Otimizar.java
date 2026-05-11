package WarRoom;


import java.util.List;


public class Otimizar {

    public List<Integer> resolver(Grafo grafo) {
        Encontrar encontrar = new Encontrar(grafo);
        return encontrar.calcularCoberturaMinima();
    }
}