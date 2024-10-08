public class ListaDuplamenteLigada {
    private Nodo principal;
    private Nodo finalLista;
    private int tamanho;

    /**
     * Representa um nó da lista.
     */
    private class Nodo {
        int valor;
        Nodo próximo;
        Nodo anterior;

        Nodo(int valor) {
            this.valor = valor;
            this.próximo = null;
            this.anterior = null;
        }
    }

    /**
     * @param valor o valor a ser adicionado no início
     */
    public void adicionarPrimeiro(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (principal == null) {
            principal = finalLista = novoNodo;
        } else {
            novoNodo.próximo = principal;
            principal.anterior = novoNodo;
            principal = novoNodo;
        }
        tamanho++;
    }

    /**
     * @param valor o valor a ser adicionado no fim da lista
     */
    public void adicionarÚltimo(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (finalLista == null) {
            principal = finalLista = novoNodo;
        } else {
            finalLista.próximo = novoNodo;
            novoNodo.anterior = finalLista;
            finalLista = novoNodo;
        }
        tamanho++;
    }

    /**
     * @param valor  o valor a ser adicionado na posição especificada
     * @param índice a posição onde o valor será adicionado
     * @throws IndexOutOfBoundsException se o índice for inválido
     */
    public void adicionar(int valor, int índice) {
        if (índice < 0 || índice > tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }

        if (índice == 0) {
            adicionarPrimeiro(valor);
        } else if (índice == tamanho) {
            adicionarÚltimo(valor);
        } else {
            Nodo novoNodo = new Nodo(valor);
            Nodo atual = principal;

            for (int i = 0; i < índice; i++) {
                atual = atual.próximo;
            }

            novoNodo.próximo = atual;
            novoNodo.anterior = atual.anterior;
            atual.anterior.próximo = novoNodo;
            atual.anterior = novoNodo;
            tamanho++;
        }
    }

    /**
     * Retorna o número de elementos na lista.
     */
    public int tamanho() {
        return tamanho;
    }

    public void imprimirLista() {
        Nodo atual = principal;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.próximo;
        }
        System.out.println();
    }

    // Método principal para executar o código
    public static void main(String[] args) {
        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();

        // Testando a lista
        lista.adicionarÚltimo(10);
        lista.adicionarÚltimo(20);
        lista.adicionarPrimeiro(5);
        lista.adicionar(15, 2);
        
        System.out.println("Lista após adições:");
        lista.imprimirLista(); // Esperado: 5 10 15 20

        System.out.println("Tamanho da lista: " + lista.tamanho()); // Esperado: 4
    }
}
