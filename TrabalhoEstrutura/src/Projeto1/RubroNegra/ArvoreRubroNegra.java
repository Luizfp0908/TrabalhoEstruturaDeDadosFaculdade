package Projeto1.RubroNegra;

public class ArvoreRubroNegra {
    private NoRB raiz;
    private final boolean VERMELHO = true;
    private final boolean PRETO = false;

    public ArvoreRubroNegra() {
        this.raiz = null;
    }


    private void rotarEsquerda(NoRB x) {
        NoRB y = x.direita;
        x.direita = y.esquerda;

        if (y.esquerda != null) {
            y.esquerda.pai = x;
        }
        y.pai = x.pai;

        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }

        y.esquerda = x;
        x.pai = y;
    }


    private void rotarDireita(NoRB y) {
        NoRB x = y.esquerda;
        y.esquerda = x.direita;

        if (x.direita != null) {
            x.direita.pai = y;
        }
        x.pai = y.pai;

        if (y.pai == null) {
            raiz = x;
        } else if (y == y.pai.direita) {
            y.pai.direita = x;
        } else {
            y.pai.esquerda = x;
        }

        x.direita = y;
        y.pai = x;
    }


    public void inserir(int valor) {
        NoRB novo = new NoRB(valor);
        NoRB y = null;
        NoRB x = raiz;


        while (x != null) {
            y = x;
            if (novo.valor < x.valor) {
                x = x.esquerda;
            } else if (novo.valor > x.valor) {
                x = x.direita;
            } else {
                return;
            }
        }


        novo.pai = y;
        if (y == null) {
            raiz = novo;
        } else if (novo.valor < y.valor) {
            y.esquerda = novo;
        } else {
            y.direita = novo;
        }


        if (novo.pai == null) {
            novo.cor = PRETO;
            return;
        }


        if (novo.pai.pai == null) {
            return;
        }


        consertarInsercao(novo);
    }


    private void consertarInsercao(NoRB k) {
        NoRB tio;


        while (k.pai != null && k.pai.cor == VERMELHO) {


            if (k.pai == k.pai.pai.esquerda) {
                tio = k.pai.pai.direita;


                if (tio != null && tio.cor == VERMELHO) {
                    k.pai.cor = PRETO;
                    tio.cor = PRETO;
                    k.pai.pai.cor = VERMELHO;
                    k = k.pai.pai;
                } else {

                    if (k == k.pai.direita) {
                        k = k.pai;
                        rotarEsquerda(k);
                    }

                    k.pai.cor = PRETO;
                    k.pai.pai.cor = VERMELHO;
                    rotarDireita(k.pai.pai);
                }
            }

            else {
                tio = k.pai.pai.esquerda;

                if (tio != null && tio.cor == VERMELHO) {
                    k.pai.cor = PRETO;
                    tio.cor = PRETO;
                    k.pai.pai.cor = VERMELHO;
                    k = k.pai.pai;
                } else {
                    if (k == k.pai.esquerda) {
                        k = k.pai;
                        rotarDireita(k);
                    }
                    k.pai.cor = PRETO;
                    k.pai.pai.cor = VERMELHO;
                    rotarEsquerda(k.pai.pai);
                }
            }
        }

        raiz.cor = PRETO;
    }

    // --- 5. REMOÇÃO ---
    public void remover(int valor) {
        NoRB z = raiz;
        // Busca o nó a ser removido
        while (z != null) {
            if (valor == z.valor) {
                break;
            } else if (valor < z.valor) {
                z = z.esquerda;
            } else {
                z = z.direita;
            }
        }


        if (z == null) return;

        NoRB x;
        NoRB y = z;
        boolean corOriginalDeY = y.cor;


        if (z.esquerda == null) {
            x = z.direita;
            transplantar(z, z.direita);
        } else if (z.direita == null) {
            x = z.esquerda;
            transplantar(z, z.esquerda);
        } else {

            y = z.direita;
            while (y.esquerda != null) {
                y = y.esquerda;
            }
            corOriginalDeY = y.cor;
            x = y.direita;

            if (y.pai == z) {
                if (x != null) x.pai = y;
            } else {
                transplantar(y, y.direita);
                y.direita = z.direita;
                if (y.direita != null) y.direita.pai = y;
            }
            transplantar(z, y);
            y.esquerda = z.esquerda;
            if (y.esquerda != null) y.esquerda.pai = y;
            y.cor = z.cor;
        }

        // Se o nó removido (ou movido) era Preto, precisamos consertar as regras
        if (corOriginalDeY == PRETO) {
            consertarRemocao(x, y.pai); // Passamos o pai também porque x pode ser null
        }
    }


    private void transplantar(NoRB u, NoRB v) {
        if (u.pai == null) {
            raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        if (v != null) {
            v.pai = u.pai;
        }
    }

    private void consertarRemocao(NoRB x, NoRB paiDeX) {

        while (x != raiz && (x == null || x.cor == PRETO)) {

            if (x == paiDeX.esquerda) {
                NoRB irmao = paiDeX.direita;


                if (irmao != null && irmao.cor == VERMELHO) {
                    irmao.cor = PRETO;
                    paiDeX.cor = VERMELHO;
                    rotarEsquerda(paiDeX);
                    irmao = paiDeX.direita; // Atualiza o irmão
                }


                if ((irmao.esquerda == null || irmao.esquerda.cor == PRETO) &&
                        (irmao.direita == null || irmao.direita.cor == PRETO)) {
                    irmao.cor = VERMELHO;
                    x = paiDeX;
                    paiDeX = x.pai;
                } else {

                    if (irmao.direita == null || irmao.direita.cor == PRETO) {
                        if (irmao.esquerda != null) irmao.esquerda.cor = PRETO;
                        irmao.cor = VERMELHO;
                        rotarDireita(irmao);
                        irmao = paiDeX.direita;
                    }


                    irmao.cor = paiDeX.cor;
                    paiDeX.cor = PRETO;
                    if (irmao.direita != null) irmao.direita.cor = PRETO;
                    rotarEsquerda(paiDeX);
                    x = raiz;
                }
            } else {

                NoRB irmao = paiDeX.esquerda;

                if (irmao != null && irmao.cor == VERMELHO) {
                    irmao.cor = PRETO;
                    paiDeX.cor = VERMELHO;
                    rotarDireita(paiDeX);
                    irmao = paiDeX.esquerda;
                }

                if ((irmao.direita == null || irmao.direita.cor == PRETO) &&
                        (irmao.esquerda == null || irmao.esquerda.cor == PRETO)) {
                    irmao.cor = VERMELHO;
                    x = paiDeX;
                    paiDeX = x.pai;
                } else {
                    if (irmao.esquerda == null || irmao.esquerda.cor == PRETO) {
                        if (irmao.direita != null) irmao.direita.cor = PRETO;
                        irmao.cor = VERMELHO;
                        rotarEsquerda(irmao);
                        irmao = paiDeX.esquerda;
                    }

                    irmao.cor = paiDeX.cor;
                    paiDeX.cor = PRETO;
                    if (irmao.esquerda != null) irmao.esquerda.cor = PRETO;
                    rotarDireita(paiDeX);
                    x = raiz;
                }
            }
        }


        if (x != null) {
            x.cor = PRETO;
        }
    }

    public boolean buscar(int valor) {
        NoRB atual = raiz;

        // Desce na árvore procurando o valor
        while (atual != null) {
            if (valor == atual.valor) {
                return true; // Achou!
            } else if (valor < atual.valor) {
                atual = atual.esquerda; // Procura na esquerda
            } else {
                atual = atual.direita;  // Procura na direita
            }
        }
        return false;
    }


    public int calcularAltura() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(NoRB no) {
        if (no == null) {
            return -1;
        }


        int alturaEsquerda = calcularAlturaRecursivo(no.esquerda);
        int alturaDireita = calcularAlturaRecursivo(no.direita);


        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }
}

