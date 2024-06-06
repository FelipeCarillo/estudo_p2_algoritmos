package fila_lista_ligada;

public class Fila<E> {
    private No<E> primeiro;
    private No<E> ultimo;

    // temos somente o construtor padrão
    public boolean estaVazia() {
        return primeiro == null;
    }

    public void enfileira(E info) {
        No<E> novo = new No<>(info);
        if (estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    public E desenfileira() {
        if (estaVazia())
            return null;
        E temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) // esvaziou a fila
            ultimo = null;
        return temp;
    }

    @Override
    public String toString() {
        if (estaVazia())
            return "fila vazia";
        String s = "";
        No<E> aux = primeiro;
        while (aux != null) {
            s += aux.getInfo() + " ";
            aux = aux.getProximo();
        }
        return s;
    }
}