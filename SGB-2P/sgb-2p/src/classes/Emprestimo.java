package classes;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private String data_emp;
    private String data_dev;

    //Construtor utilizado para garantir que todos os atributos essenciais sejam declarados;
    public Emprestimo(Livro livro, Cliente cliente, String data_emp, String data_dev) {
        this.livro = livro;
        this.cliente = cliente;
        this.data_emp = data_emp;
        this.data_dev = data_dev;
    }
    //metódo get para acessar as informações do livro
    public Livro getLivro() {
        return this.livro;
    }

    //metódo get para acessar as informações do Cliente
    public Cliente getCliente() {
        return this.cliente;
    }

    //metódo get para acessar as informações da data de empréstimo
    public String getData_emp() {
        return this.data_emp;
    }

    //metódo get para acessar as informações da data de devolução
    public String getData_dev() {
            return this.data_dev;
    }
    //Sobreescrita do metódo toString, para que ele retorne as informações do empréstimo
    @Override
    public String toString() {
        return "Livro: " + this.livro + "\n" +
                "Cliente: " + this.cliente + "\n" +
                "Data de empréstimo: " + this.data_emp + "\n" +
                "Data de devolução" + this.data_dev + "\n";
    }

}
