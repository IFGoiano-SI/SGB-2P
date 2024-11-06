package classes;

public class Devolucao {
    private Cliente cliente;
    private Livro livro;

    public Devolucao(Cliente cliente, Livro livro) {
        this.cliente = cliente;
        this.livro = livro;
    }

    public void devolverLivro() {
        livro.devolver();
        System.out.println("A devolução do livro foi realizada com sucesso para o honoravel cliente: " + cliente.getNome());
    }
}
