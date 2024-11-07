package classes;

public class Emprestimo {
    Livro livro;
    Cliente cliente;
    int data_emp;
    int data_dev;

    Emprestimo(Livro livro, Cliente cliente, int data_emp, int data_dev) {
        this.livro = livro;
        this.cliente = cliente;
        this.data_emp = data_emp;
        this.data_dev = data_dev;
    }
}
