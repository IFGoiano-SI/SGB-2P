package classes;

import java.util.List;

public class Relatorio {

    // Método para listar clientes
    public static void listarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }

        System.out.println("Clientes Cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("------------------------------------------------");
        }
    }

    // Método para listar livros
    public static void listarLivros(List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
            return;
        }

        System.out.println("Livros Cadastrados:");
        for (Livro livro : livros) {
            System.out.println(livro.getDadosLivro());
            System.out.println("------------------------------------------------");
        }
    }

    // Método para listar empréstimos ativos
    public static void listarEmprestimos(List<Emprestimo> emprestimos) {
        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos ativos.");
            return;
        }

        System.out.println("Empréstimos Ativos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Cliente: " + emprestimo.cliente.getNome());
            System.out.println("Livro: " + emprestimo.livro.getTitulo());
            System.out.println("Data de Empréstimo: " + emprestimo.data_emp);
            System.out.println("Data de Devolução: " + emprestimo.data_dev);
            System.out.println("------------------------------------------------");
        }
    }

    // Método que exibe o menu de relatórios
    public static void exibirMenuRelatorio(List<Cliente> clientes, List<Livro> livros, List<Emprestimo> emprestimos) {
        System.out.println("Escolha uma opção para exibir o relatório:");
        System.out.println("1. Listar Clientes");
        System.out.println("2. Listar Livros");
        System.out.println("3. Listar Empréstimos Ativos");
        System.out.println("0. Sair");

        // Simulação de leitura de entrada (exemplo de escolha de opções)
        // Aqui você pode substituir por algo mais dinâmico, como um Scanner para interagir com o usuário
        int opcao = 1; // Simulação de escolha
        switch (opcao) {
            case 1:
                listarClientes(clientes);
                break;
            case 2:
                listarLivros(livros);
                break;
            case 3:
                listarEmprestimos(emprestimos);
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
