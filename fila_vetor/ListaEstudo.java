import java.util.Random;

public class ListaEstudo {
    public static void main(String[] args) {
        Random random = new Random();

        // Exercício 13
        System.out.println(
                "Exercicio 13. Considere uma fila vazia sobre vetores, para a qual foram executadas 32 insercoes, 15 \r\n"
                        + //
                        "remocoes, 5 das quais geraram fila vazia. Qual o tamanho atual da fila?\n");
        System.out.println(
                "Resposta: Teremos no final um tamanho de 17; pois foram inseridos 32 e removidos 15: 32 - 15 = 17");

        // Exercício 14.
        System.out.println(
                "\nExercicio 14. Se a fila da questao anterior foi implementada com um vetor de tamanho 30, sem nunca ter \r\n"
                        + //
                        "dado fila cheia, quais os possiveis valores dos atributos primeiro e ultimo?\n");
        System.out.println(
                "Resposta: Para calcularmos os valores utilizaremos a aritmetica modular, ou seja, com a fila vazia o primeiro e ultimo \r\n"
                        + //
                        "valores eram 0, contudo apos as insercoes e remocoes, podemos prever seu valor utilizando o seguinte calculo:\r\n"
                        + //
                        "\nprimeiro = (0 + n_remocoes)%tamanho\r\n" + //
                        "ultimo = (0 + n_insercoes)%tamanho\r\n" + //
                        "\nSendo assim primeiro sera 15 e o ultimo 2");

        // Exercício 15.
        System.out.println("\nExercicio 15.");
        Fila fila = new Fila();
        for (int i = 1; i <= 10; i++) {
            fila.enfileira(i);
        }
        System.out.println(fila.toString());
        fila.limpaFila();
        System.out.println();
        System.out.println(fila.toString());

        // Exercício 16.
        System.out.println("\nExercicio 16.");
        fila = new Fila();
        for (int i = 1; i <= 9; i++) {
            fila.enfileira(i);
        }
        System.out.println(fila.toString());
        fila.furaFila(20);
        System.out.println();
        System.out.println(fila.toString());

        // Exercicio 19.
        System.out.println("\nExercicio 19.");
        fila = new Fila();
        for (int i = 1; i <= 9; i++) {
            fila.enfileira(random.nextInt(1, 100));
        }
        fila.enfileira(101);
        System.out.println(fila.toString());
        int pos = fila.busque(101);
        System.out.println("A posicao de " + 101 + " eh " + pos);

        // Exercicio 20.
        System.out.println("\nExercicio 20.");
        fila = new Fila();
        for (int i = 1; i <= 10; i++) {
            fila.enfileira(random.nextInt(1, 100));
        }
        System.out.println(fila.toString());
        int max = fila.max();
        System.out.println("O valor max eh " + max);

        // Exercicio 21.
        System.out.println("\nExercicio 21.");
        fila = new Fila();
        for (int i = 1; i <= 10; i++) {
            fila.enfileira(random.nextInt(1, 100));
        }
        System.out.println(fila.toString());
        int min = fila.min();
        System.out.println("O valor min eh " + min);

        // Exercicio 22.
        System.out.println("\nExercicio 22.");
        fila = new Fila();
        for (int i = 0; i < 10; i++) {
            fila.enfileira(random.nextInt(1, 100));
        }
        System.out.println(fila.toString());
        fila.maxNoUltimo();
        System.out.println();
        System.out.println(fila.toString());

        // Exercicio 22.
        System.out.println("\nExercicio 23.");
        fila = new Fila();
        for (int i = 0; i < 10; i++) {
            fila.enfileira(random.nextInt(1, 100));
        }
        System.out.println(fila.toString());
        fila.minNoPrimeiro();
        System.out.println();
        System.out.println(fila.toString());

    }
}
