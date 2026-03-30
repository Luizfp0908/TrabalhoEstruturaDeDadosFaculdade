package Projeto1;

public class No {
    protected int valor;
    protected int altura;
    protected No direita;
    protected No esquerda;

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 0;
    }
}
