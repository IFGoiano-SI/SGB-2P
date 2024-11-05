import classes.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente();  // cadastra um novo cliente
        biblioteca.listarClientes();    // lista os clientes
    }
}
