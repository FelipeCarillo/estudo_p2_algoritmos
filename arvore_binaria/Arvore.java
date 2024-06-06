package arvore_binaria;

import java.util.ArrayList;

public class Arvore {
    private No raiz;

    public boolean estaVazia() {
        return raiz == null;
    }

    public void insere(int i) {
        No novo = new No(i);
        if (estaVazia())
            raiz = novo;
        else
            insereRec(novo, raiz);
    }

    void insereRec(No novo, No atual) {
        if (novo.getInfo() <= atual.getInfo()) { // vai pra esquerda
            if (atual.getEsquerda() == null)
                atual.setEsquerda(novo);
            else
                insereRec(novo, atual.getEsquerda());
        } else { // vai pra direita
            if (atual.getDireita() == null)
                atual.setDireita(novo);
            else
                insereRec(novo, atual.getDireita());
        }
    }

    public String toStringEmOrdem() {
        if (estaVazia())
            return "arvore vazia";
        return toStringEmOrdemRec(raiz);
    }

    String toStringEmOrdemRec(No atual) {
        if (atual == null)
            return "";
        return toStringEmOrdemRec(atual.getEsquerda())
                + atual.getInfo() + " "
                + toStringEmOrdemRec(atual.getDireita());
    }

    public int numeroNos() {
        if (estaVazia())
            return 0;
        return numeroNosRec(raiz);
    }

    int numeroNosRec(No atual) {
        if (atual == null)
            return 0;
        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita());
    }

    public int altura() {
        if (estaVazia())
            return 0;
        return alturaRec(raiz);
    }

    int alturaRec(No atual) {
        if (atual.getEsquerda() == null && atual.getDireita() == null)
            return 0;

        int alturaEsq = 0;
        if (atual.getEsquerda() != null)
            alturaEsq = alturaRec(atual.getEsquerda());

        int alturaDir = atual.getDireita() != null ? alturaRec(atual.getDireita()) : 0;

        return alturaEsq > alturaDir ? alturaEsq + 1 : alturaDir + 1;

    }

    public int numeroFolhas() {
        if (estaVazia())
            return 0;
        return numeroFolhasRec(raiz);
    }

    int numeroFolhasRec(No atual) {
        if (atual != null) {
            if (atual.getDireita() == null && atual.getEsquerda() == null)
                return 1;
            return numeroFolhasRec(atual.getDireita()) + numeroFolhasRec(atual.getEsquerda());
        }
        return 0;
    }

    public boolean busca(int x) {
        if (estaVazia())
            return false;
        return buscaRec(raiz, x);
    }

    boolean buscaRec(No atual, int x) {
        if (atual == null)
            return false;
        if (atual.getInfo() == x)
            return true;
        if (x <= atual.getInfo())
            return buscaRec(atual.getEsquerda(), x);
        return buscaRec(atual.getDireita(), x);
    }

    public int proximo(int x) {
        if (estaVazia())
            return -1;
        ArrayList<Integer> lista = new ArrayList<>();
        lineariza(lista, raiz);
        System.out.println(lista);
        int posicao = lista.indexOf(x);
        // if (posicao != -1 && posicao != lista.size()-1) {
        // return lista.get(posicao + 1);
        // }
        // return -1;

        // return posicao != -1 && posicao != lista.size()-1 ? lista.get(posicao + 1) :
        // -1;

        return posicao == -1 || posicao == lista.size() - 1 ? -1 : lista.get(posicao + 1);

    }

    void lineariza(ArrayList<Integer> lista, No atual) {
        if (atual != null) {
            lineariza(lista, atual.getEsquerda());
            lista.add(atual.getInfo());
            lineariza(lista, atual.getDireita());
        }
    }

    public boolean remove(int x) {
        if (estaVazia())
            return false;
        return removeRec(x, raiz, null, false); // posição atual e o pai
    }

    boolean removeRec(int x, No atual, No pai, boolean eFilhoEsquerdo) {
        if (atual != null) {
            if (x == atual.getInfo()) {
                if (atual.getEsquerda() == null && atual.getDireita() == null) { // é folha
                    if (atual == raiz)
                        raiz = null;
                    else if (eFilhoEsquerdo)
                        pai.setEsquerda(null);
                    else
                        pai.setDireita(null);
                } else if (atual.getEsquerda() == null) { // só tem o filho direito
                    if (atual == raiz) {
                        raiz = atual.getDireita();
                    } else if (eFilhoEsquerdo) {
                        pai.setEsquerda(atual.getDireita());
                    } else {
                        pai.setDireita(atual.getDireita());
                    }
                } else if (atual.getDireita() == null) { // só tem o filho esquerdo
                    if (atual == raiz) {
                        raiz = atual.getEsquerda();
                    } else if (eFilhoEsquerdo) {
                        pai.setEsquerda(atual.getEsquerda());
                    } else {
                        pai.setDireita(atual.getEsquerda());
                    }
                } else { // tem os 2 filhos
                         // a sub-árvore da direita é "adotada" pelo nó pai
                    if (atual == raiz) {
                        raiz = atual.getDireita();
                    } else if (eFilhoEsquerdo) {
                        pai.setEsquerda(atual.getDireita());
                    } else {
                        pai.setDireita(atual.getDireita());
                    }
                    // a sub-árvore da esquerda é "adotada" pelo sucessor
                    // sucessor = menor entre os maiores que o atual
                    No sucessor = atual.getDireita();
                    while (sucessor.getEsquerda() != null) {
                        sucessor = sucessor.getEsquerda();
                    }
                    sucessor.setEsquerda(atual.getEsquerda());
                }
                return true;
            } else if (x < atual.getInfo()) { // perceba as diferenças na implementação
                return removeRec(x, atual.getEsquerda(), atual, true);
            } else {
                eFilhoEsquerdo = false;
                pai = atual;
                return removeRec(x, atual.getDireita(), pai, eFilhoEsquerdo);
            }
        }
        return false;
    }
}