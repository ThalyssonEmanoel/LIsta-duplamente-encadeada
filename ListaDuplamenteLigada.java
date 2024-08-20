public class ListaDuplamenteLigada {
    private No inicio;
    private No fim;
    private int tamanho;

    /**
     * Representa um nó da lista.
     */
    class No {
        int valor;
        No proximo;
        No anterior;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
            this.anterior = null;
        }
    }

    /**
     * Adiciona um valor no início da lista.
     * @param valor o valor a ser adicionado no início
     */
    public void AddFirst(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
        tamanho++;
    }

    /**
     * Adiciona um valor no fim da lista.
     * @param valor o valor a ser adicionado no fim da lista
     */
    public void AddLast(int valor) {
        No novoNo = new No(valor);
        if (fim == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
        tamanho++;
    }

    /**
     * Adiciona um valor na posição especificada.
     * @param valor o valor a ser adicionado
     * @param i a posição onde o valor será adicionado
     * @exception IndexOutOfBoundsException se o i for inválido
     */
    public void Add(int valor, int i) {
        if (i < 0 || i > tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }

        if (i == 0) {
            AddFirst(valor);
        } else if (i == tamanho) {
            AddLast(valor);
        } else {
            No novoNo = new No(valor);
            No atual = inicio;

            // Navega até o nó na posição i
            for (int j = 0; j < i - 1; j++) {
                atual = atual.proximo;
            }

            // Atualiza os ponteiros para inserir o novo nó
            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;
            atual.proximo.anterior = novoNo;
            atual.proximo = novoNo;

            tamanho++;
        }
    }

    /**
     * Remove o último nó da lista e retorna seu valor.
     * @return o valor do nó removido
     * @exception NoSuchElementException se a lista estiver vazia
     */
    public int removeLast() {
        if (fim == null) {
            throw new java.util.NoSuchElementException("A lista está vazia.");
        }

        int valor = fim.valor;

        if (inicio == fim) { // Se a lista tiver apenas um elemento
            inicio = fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
        tamanho--;

        return valor;
    }

    /**
     * Retorna o número de elementos na lista.
     * @return o número de elementos na lista
     */
    public int size() {
        return tamanho;
    }

    /**
     * Imprime os elementos da lista.
     */
    public void PrintList() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
        
        lista.AddLast(10);
        lista.AddLast(20);
        lista.AddFirst(5);
        lista.Add(15, 2);
        
        System.out.println("\n\n\n\n\n"+"Lista após adições:");

        lista.PrintList(); 
        System.out.println("Tamanho: " + lista.size());
        System.out.println("---------------------");

        int valorRemovido = lista.removeLast();
        System.out.println("Valor removido do fim: " + valorRemovido);
        System.out.println("---------------------");
        System.out.println("Lista após remoção do fim:");
        lista.PrintList();
        System.out.println("Tamanho: " + lista.size() + "\n\n\n\n\n");
    }        
}