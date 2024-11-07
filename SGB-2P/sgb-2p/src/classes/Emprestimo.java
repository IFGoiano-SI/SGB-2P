package classes;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private String data_emp;
    private String data_dev;

    public Emprestimo(Livro livro, Cliente cliente, String data_emp, String data_dev) {
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
    public String getData_emp() {
        return this.data_emp;
    }
    public String getData_dev() {
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
