package fila_lista_ligada;

class No<E> {
    private E info;
    private No<E> proximo;

    public No(E info) {
        setInfo(info);
        setProximo(null); // por clareza
    }

    public E getInfo() {
        return info;
    }

    public No<E> getProximo() {
        return proximo;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public void setProximo(No<E> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return info + "";
    }
}