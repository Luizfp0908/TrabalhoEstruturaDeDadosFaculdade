package Projeto1;

public class Avl {
    protected No raiz;
    private int getAltura(No n) {
        if (n == null) {
            return -1;
        }
        return n.altura;
    }

    private int getFatorEquilibrio(No n) {
        if (n == null) {
            return 0;
        }
        return getAltura(n.esquerda) - getAltura(n.direita);
    }
    private No rotarDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;
        x.direita = y;
        y.esquerda = T2;
        y.altura = Math.max(getAltura(y.esquerda), getAltura(y.direita)) + 1;
        x.altura = Math.max(getAltura(x.esquerda), getAltura(x.direita)) + 1;
        return x;
    }

    private No rotarEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;
        y.esquerda = x;
        x.direita = T2;
        x.altura = Math.max(getAltura(x.esquerda), getAltura(x.direita)) + 1;
        y.altura = Math.max(getAltura(y.esquerda), getAltura(y.direita)) + 1;
        return y;
    }

    public void inserir(int valor) {
         raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No no, int valor) {

        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(getAltura(no.esquerda), getAltura(no.direita));


        int fb = getFatorEquilibrio(no);

        // CASO 1: Esquerda-Esquerda (Rotação Direita)
        if (fb > 1 && valor < no.esquerda.valor) {
            return rotarDireita(no);
        }

        // CASO 2: Direita-Direita (Rotação Esquerda)
        if (fb < -1 && valor > no.direita.valor) {
            return rotarEsquerda(no);
        }

        // CASO 3: Esquerda-Direita (Rotação Dupla: Esquerda depois Direita)
        if (fb > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotarEsquerda(no.esquerda);
            return rotarDireita(no);
        }

        // CASO 4: Direita-Esquerda (Rotação Dupla: Direita depois Esquerda)
        if (fb < -1 && valor < no.direita.valor) {
            no.direita = rotarDireita(no.direita);
            return rotarEsquerda(no);
        }

        return no;
    }
    public boolean buscar(int valor) {
        No atual = raiz;
        while (atual != null) {
            if (valor == atual.valor) {
                return true;
            }
            if (valor < atual.valor) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }
        return false;
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }
    private No removerRecursivo(No atual, int valor) {
        if (atual == null) {
            return atual;
        }

        if (valor < atual.valor) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = removerRecursivo(atual.direita, valor);
        } else {
            if (atual.esquerda == null || atual.direita == null) {
                No temp = null;
                if (atual.esquerda == null) {
                    temp = atual.direita;
                } else {
                    temp = atual.esquerda;
                }


                if (temp == null) {
                    atual = null;
                } else {

                    atual = temp;
                }
            } else {

                int valorSucessor = encontrarMenorValor(atual.direita);
                atual.valor = valorSucessor;
                atual.direita = removerRecursivo(atual.direita, valorSucessor);
            }
        }


        if (atual == null) {
            return atual;
        }


        atual.altura = Math.max(getAltura(atual.esquerda), getAltura(atual.direita)) + 1;

        // ver o equilibrio
        int fb = getFatorEquilibrio(atual);


        if (fb > 1 && getFatorEquilibrio(atual.esquerda) >= 0) {
            return rotarDireita(atual);
        }


        if (fb > 1 && getFatorEquilibrio(atual.esquerda) < 0) {
            atual.esquerda = rotarEsquerda(atual.esquerda);
            return rotarDireita(atual);
        }


        if (fb < -1 && getFatorEquilibrio(atual.direita) <= 0) {
            return rotarEsquerda(atual);
        }


        if (fb < -1 && getFatorEquilibrio(atual.direita) > 0) {
            atual.direita = rotarDireita(atual.direita);
            return rotarEsquerda(atual);
        }

        return atual;
    }

    private int encontrarMenorValor(No raiz) {
        if (raiz.esquerda == null) {
            return raiz.valor;
        } else {
            return encontrarMenorValor(raiz.esquerda);
        }
    }

    public int calcularAltura() {
        return getAltura(raiz);
    }
}

