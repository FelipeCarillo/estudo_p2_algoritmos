public class Fila {
    private int[] dados;
    private int primeiro, ultimo, tamanho;

    public static final int CAPACIDADE_MINIMA = 10;

    public Fila() {
        this(CAPACIDADE_MINIMA);
    }

    public Fila(int capacidade) {
        dados = capacidade < 10 ? new int[10] : new int[capacidade];
        ultimo = dados.length - 1;
        primeiro = 0;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == dados.length;
    }

    int proxima(int pos) {
        return (pos + 1) % dados.length;
    }

    int anterior(int pos) {
        return (pos - 1 + dados.length) % dados.length;
    }

    public void enfileira(int i) {
        if (!estaCheia()) {
            ultimo = proxima(ultimo);
            dados[ultimo] = i;
            tamanho++;
        }
    }

    public int desenfileira() {
        if (estaVazia())
            return -1;
        int temp = dados[primeiro];
        primeiro = proxima(primeiro);
        tamanho--;
        return temp;
    }

    public void furaFila(int i) {
        if (!estaCheia()) {
            primeiro = anterior(primeiro);
            dados[primeiro] = i;
            tamanho++;
        }
    }

    public boolean limpaFila() {
        if (estaVazia())
            return true;

        int count = tamanho; // número de elementos na fila
        for (int i = 0; i < count; i++) {
            int elemento = desenfileira();
            if (elemento % 2 != 0) { // se o elemento for ímpar
                enfileira(elemento);
            }
        }

        return true;
    }

    public int busque(int valor_alvo) {
        if (estaVazia())
            return -1;

        int aux = primeiro;
        int count = tamanho;

        while (count > 0) {
            if (dados[aux] == valor_alvo) {
                return aux;
            }
            aux = proxima(aux);
            count--;
        }

        return -1;
    }

    public int max() {
        if (estaVazia())
            return -1;

        int max = dados[primeiro];
        int aux = proxima(primeiro);
        int count = tamanho - 1;

        while (count > 0) {
            if (dados[aux] > max)
                max = dados[aux];
            aux = proxima(aux);
            count--;
        }

        return max;
    }

    public int min() {
        if (estaVazia())
            return -1;

        int min = dados[primeiro];
        int aux = proxima(primeiro);
        int count = tamanho - 1;

        while (count > 0) {
            if (min > dados[aux]) {
                min = dados[aux];
            }
            aux = proxima(aux);
            count--;
        }

        return min;
    }

    public boolean maxNoUltimo() {
        if (estaVazia())
            return false;

        int pos_max = primeiro;
        int aux = proxima(primeiro);
        int count = tamanho - 1;

        while (count > 0) {
            if (dados[aux] > dados[pos_max]) {
                pos_max = aux;
            }
            aux = proxima(aux);
            count--;
        }

        count = tamanho;
        int max_valor = dados[pos_max];

        for (int i = 0; i < count; i++) {
            int elemento = desenfileira();
            if (elemento != max_valor) {
                enfileira(elemento);
            }
        }

        enfileira(max_valor);

        return true;
    }

    public boolean minNoPrimeiro() {
        if (estaVazia())
            return false;

        int pos_min = primeiro;
        int aux = proxima(primeiro);
        int count = tamanho - 1;

        while (count > 0) {
            if (dados[pos_min] > dados[aux]) {
                pos_min = aux;
            }
            aux = proxima(aux);
            count--;
        }

        int valor_min = dados[pos_min];
        count = tamanho;

        for (int i = 0; i < count; i++) {
            int elemento = desenfileira();
            if (elemento != valor_min) {
                enfileira(elemento);
            }
        }

        furaFila(valor_min);

        return true;
    }

    @Override
    public String toString() {
        if (estaVazia())
            return "fila vazia";
        String s = "";
        int i = primeiro;
        do {
            s = s + dados[i] + " ";
            i = proxima(i);
        } while (i != proxima(ultimo));
        return s;
    }

    public String stringVetor() {
        if (estaVazia())
            return "_ _ _ _ _ _ _ _ _ _ ";
        String s = "";
        int i;
        if (primeiro <= ultimo) {
            for (i = 0; i < primeiro; i++)
                s += "_ ";
            for (i = primeiro; i <= ultimo; i++)
                s += dados[i] + " ";
            for (i = ultimo + 1; i < dados.length; i++)
                s += "_ ";
        } else {
            for (i = 0; i <= ultimo; i++)
                s += dados[i] + " ";
            for (i = ultimo + 1; i < primeiro; i++)
                s += "_ ";
            for (i = primeiro; i < dados.length; i++)
                s += dados[i] + " ";
        }
        return s;
    }
}