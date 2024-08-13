public class ListaDuplamenteLigada {
    private No inicio;
    private No fim;
    private int tamanho;

    /**
     * Representa um nó da lista.
     * @author Thalysson Emanoel
     */
    private static class No {
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
     * @param valor o valor a ser adicionado no início
     * @author Thalysson Emanoel
     *  if ---> Quando a lista está vazia, o novo nó se torna tanto o início quanto o fim da lista,
     * garantindo que ambos os ponteiros apontem para o único nó presente.
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
     * @param valor o valor a ser adicionado no fim da lista
     * @see O valor só é adicionado se for positivo.
     * @author Thalysson Emanoel
     * if ---> Quando a lista está vazia, o novo nó se torna tanto o início quanto o fim da lista,
     * garantindo que ambos os ponteiros apontem para o único nó presente.
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
     * @param valor  o valor a ser adicionado na posição especificada
     * @param i a posição onde o valor será adicionado
     * @exception IndexOutOfBoundsException se o i for inválido
     * @author Thalysson Emanoel
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
            No novoNo = new No(valor);
            No atual = inicio;

            for (int i = 0; i < i; i++) {
                atual = atual.proximo;
            }

            novoNo.proximo = atual;
            novoNo.anterior = atual.anterior;
            atual.anterior.proximo = novoNo;
            atual.anterior = novoNo;
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
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    /**
     * @author Thalysson Emanoel
     * @author Caio de Oliveira
     * @author Daniel Pereira
     */
        public static void main(String[] args) {
        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
        
        lista.AddLast(10);
        lista.AddLast(20);
        lista.AddFirst(5);
        lista.Add(15, 2);
        
        System.out.println("Lista após adições:");
        lista.PrintList(); 
        
        System.out.println("Tamanho: " + lista.tamanho());
        }        
}
