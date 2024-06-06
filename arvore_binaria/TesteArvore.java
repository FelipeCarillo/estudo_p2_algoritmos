package arvore_binaria;

import java.util.Random;

public class TesteArvore {
    public static void main(String[] args) {
        Arvore abb = new Arvore();
        Random r = new Random();
        int total = r.nextInt(10) + 5;
        System.out.println("total = " + total);
        for (int i = 1; i <= total; i++) {
            int n = r.nextInt(total) + 1;
            System.out.print(n + " ");
            abb.insere(n);
        }
        System.out.println("\na arvore:\n" + abb.toStringEmOrdem());
        System.out.println("numero de nos: " + abb.numeroNos());
        System.out.println("altura da arvore: " + abb.altura());
        System.out.println("numero de folhas: " + abb.numeroFolhas());
        int x = r.nextInt(total) + 1;
        if (abb.busca(x))
            System.out.println(x + " foi encontrado");
        else
            System.out.println(x + " nao foi encontrado");

        int p = abb.proximo(x);
        if (p == -1) {
            System.out.println("ou a arvore esta vazia, ou o elemento nao existe ou ele e o ultimo");
        } else {
            System.out.println("o proximo e " + p);
        }
    }
}