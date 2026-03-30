package Projeto1;

public class Bst {
    protected No raiz;

    public Bst() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    public No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }
        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }
        return atual;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.valor) {
            return true;
        }
        if (valor < atual.valor) {
            return buscarRecursivo(atual.esquerda, valor);
        } else {
            return buscarRecursivo(atual.direita, valor);
        }
    }
    public int calcularAltura() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(No atual) {
        if (atual == null) {
            return -1;
        }
        int alturaEsquerda = calcularAlturaRecursivo(atual.esquerda);
        int alturaDireita = calcularAlturaRecursivo(atual.direita);

        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    public No removerRecursivo(No atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor < atual.valor) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = removerRecursivo(atual.direita, valor);
        } else {

            if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }


            atual.valor = encontrarMenorValor(atual.direita);

            atual.direita = removerRecursivo(atual.direita, atual.valor);
        }
        return atual;


    }

    public int encontrarMenorValor(No raiz) {
        if (raiz.esquerda == null) {
            return raiz.valor;
        } else {
            return encontrarMenorValor(raiz.esquerda);
        }
    }
}
