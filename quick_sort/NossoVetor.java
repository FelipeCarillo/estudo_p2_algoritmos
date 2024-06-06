package quick_sort;
import java.util.Random;


public class NossoVetor {
    private int ultimaPos;
    private double[] v;

    public NossoVetor(int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }

    // métodos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }

    public double[] getV() {
        return v;
    }

    // métodos modificadores - neste caso, vamos deixar private
    private void setUltimaPos(int pos) {
        if (pos >= 0 && pos < v.length) {
            ultimaPos = pos;
        } else {
            ultimaPos = v.length - 1;
        }
    }

    public boolean estaCheio() {
        return ultimaPos == v.length - 1;
    }

    public boolean estaVazio() {
        return ultimaPos == -1;
    }

    private void redimensiona(int novaCapacidade) {
        double[] temp = new double[novaCapacidade];
        for (int i = 0; i <= ultimaPos; i++)
            temp[i] = v[i];
        v = temp;
    }

    public void adiciona(double e) {
        if (estaCheio())
            redimensiona(v.length * 2);
        v[++ultimaPos] = e;
    }

    public void adiciona(double e, int pos) {
        if (estaCheio())
            redimensiona(v.length * 2);
        if (pos > ultimaPos) {
            v[++ultimaPos] = e;
        } else {
            int i;
            for (i = ultimaPos + 1; i > pos; i--) {
                v[i] = v[i - 1];
            }
            v[i] = e;
            ultimaPos++;
        }
    }

    public double remove() {
        if (estaVazio())
            return -1;
        double aux = v[ultimaPos--];
        if (ultimaPos >= 10 && ultimaPos <= v.length / 4)
            redimensiona(v.length / 2);
        return aux;
    }

    public boolean remove(double e) {
        if (estaVazio())
            return false;
        for (int i = 0; i <= ultimaPos; i++) {
            if (v[i] == e) {
                for (int j = i; j < ultimaPos; j++) {
                    v[j] = v[j + 1];
                }
                ultimaPos--;
                if (ultimaPos >= 10 && ultimaPos <= v.length / 4)
                    redimensiona(v.length / 2);
                return true;
            }
        }
        return false;
    }

    public void preencheVetor() {
        Random r = new Random();
        for (int i = 0; i < v.length; i++) {
            // adiciona(Math.random());
            // adiciona (r.nextDouble());
            // adiciona(r.nextInt());
            adiciona(r.nextInt(10 * v.length)); // operação resto
        }
    }

    public void resetVetor() {
        ultimaPos = -1;
    }

    @Override
    public String toString() {
        String s = "";
        if (estaVazio())
            s = s + "vetor vazio";
        else {
            for (int i = 0; i <= ultimaPos; i++) {
                s = s + String.format("%.0f ", v[i]);
            }
        }
        return s + "\n";
    }

    public void bubbleSort() {
        // int cont = 0;
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < v.length - i; j++) {
                // cont++;
                if (v[j] > v[j + 1]) {
                    double aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }
        // return cont;
    }

    public boolean removePrimeiraOcorrencia(double x) {
        if (estaVazio())
            return false;
        boolean achou = false;
        int i = 0;
        while (i < v.length && !achou)
            if (v[i] == x)
                achou = true;
            else
                i++;
        if (!achou)
            return false;
        for (int j = i; j < ultimaPos; j++)
            v[j] = v[j + 1];
        return true;
    }

    int partition(int p, int r) {
        double x = v[r]; /* O pivô é o último elemento do vetor */
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (v[j] <= x) {
                i = i + 1;
                double aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        i = i + 1;
        v[r] = v[i];
        v[i] = x;
        return i;
    }

    public void quickSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }

    void intercala(int p, int q, int r) {
        double[] w = new double[r - p];
        int i = p, j = q, k = 0;
        while (i < q && j < r)
            if (v[i] <= v[j])
                w[k++] = v[i++];
            else
                w[k++] = v[j++];
        while (i < q)
            w[k++] = v[i++];
        while (j < r)
            w[k++] = v[j++];
        for (i = p; i < r; i++)
            v[i] = w[i - p];
    }

    public void mergeSort(int p, int r) {
        if (p < r - 1) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q, r);
            intercala(p, q, r);
        }
    }
}