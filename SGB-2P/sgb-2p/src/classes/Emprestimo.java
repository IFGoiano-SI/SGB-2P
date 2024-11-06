package classes;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private int data_emp;
    private int data_dev;

    Emprestimo(Livro livro, Cliente cliente, int data_emp, int data_dev) {
        this.livro = livro;
        this.cliente = cliente;
        this.data_emp = data_emp;
        this.data_dev = data_dev;
    }
    public Livro getLivro() {
        return this.livro;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public int getData_emp() {
        return this.data_emp;
    }
    public int getData_dev() {
            return this.data_dev;
    }

    @Override
    public String toString() {
        return "Livro: " + this.livro + "\n" +
                "Cliente: " + this.cliente + "\n" +
                "Data de empréstimo: " + this.data_emp + "\n" +
                "Data de devolução" + this.data_dev + "\n";
    }

}
