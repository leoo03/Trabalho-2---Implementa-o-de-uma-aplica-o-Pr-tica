public class FilaEncadeada {
    private Node inicio;
    private Node fim;

    public void enfileirar(String nome) {
        Node novo = new Node(nome);
        if (fim != null) {
            fim.proximo = novo;
        }
        fim = novo;
        if (inicio == null) {
            inicio = novo;
        }
    }

    public String desenfileirar() {
        if (inicio == null) return null;
        String nome = inicio.nome;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return nome;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}
