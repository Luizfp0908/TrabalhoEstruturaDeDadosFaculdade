package Projeto1.RubroNegra;

public class NoRB {
    int valor;
    NoRB esquerda, direita, pai;
    boolean cor; // true = Vermelho, false = Preto

    public NoRB(int valor) {
        this.valor = valor;
        this.cor = true;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
