public class ListaDuplamenteLigada {
    private Nodo inicio;
    private Nodo fim;
    private int tamanho;

    /**
     * Representa um nó da lista.
     */
    private static class Nodo {
        int valor;
        Nodo proximo;
        Nodo anterior;

        Nodo(int valor) {
            this.valor = valor;
            this.proximo = null;
            this.anterior = null;
        }
    }

    /**
     * @param valor o valor a ser adicionado no início
     */
    public void AddFirst(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (inicio == null) {
            inicio = fim = novoNodo;
        } else {
            novoNodo.proximo = inicio;
            inicio.anterior = novoNodo;
            inicio = novoNodo;
        }
        tamanho++;
    }

    /**
     * @param valor o valor a ser adicionado no fim da lista
     */
    public void AddLast(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (fim == null) {
            inicio = fim = novoNodo;
        } else {
            fim.proximo = novoNodo;
            novoNodo.anterior = fim;
            fim = novoNodo;
        }
        tamanho++;
    }

    /**
     * @param valor  o valor a ser adicionado na posição especificada
     * @param i a posição onde o valor será adicionado
     * @throws IndexOutOfBoundsException se o i for inválido
     */
    public void Add(int valor, int i) {
        if (i < 0 || i > tamanho) {
            throw new IndexOutOfBoundsException("Indíce fora dos limites da lista.");
        }

        if (i == 0) {
            AddFirst(valor);
        } else if (i == tamanho) {
            AddLast(valor);
        } else {
            Nodo novoNodo = new Nodo(valor);
            Nodo atual = inicio;

            for (int i = 0; i < i; i++) {
                atual = atual.proximo;
            }

            novoNodo.proximo = atual;
            novoNodo.anterior = atual.anterior;
            atual.anterior.proximo = novoNodo;
            atual.anterior = novoNodo;
            tamanho++;
        }
    }

    /**
     * Retorna o número de elementos na lista.
     */
    public static int size() {
        return size;
    }

    public void PrintList() {
        Nodo atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    // Método Main
    public static void main(String[] args) {
        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();

        lista.AddLast(10);
        lista.AddLast(20);
        lista.AddFirst(5);
        lista.Add(15, 2);
        
        System.out.println("Lista após adições:");
        lista.PrintList(); 

        System.out.println("Tamanho da lista: " + lista.tamanho()); 
    }
}
