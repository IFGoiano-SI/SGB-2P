package classes;

import java.util.List;
import java.util.Scanner;

public class Relatorio {

    // Método para listar clientes
    public static void listarClientes(List<Cliente> clientes) {
        try {
            if (clientes == null || clientes.isEmpty()) { // Verifica se a lista é nula ou está vazia
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
        } catch (Exception e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    // Método para listar livros
    public static void listarLivros(List<Livro> livros) {
        try {
            if (livros == null || livros.isEmpty()) { // Verifica se lista é nula ou está vazia
                System.out.println("Não há livros cadastrados.");
                return;
            }

            System.out.println("Livros Cadastrados:");
            for (Livro livro : livros) {
                System.out.println(livro.getDadosLivro());
                System.out.println("------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
    }

    // Método para listar empréstimos ativos
    public static void listarEmprestimos(List<Emprestimo> emprestimos) {
        try {
            if (emprestimos == null || emprestimos.isEmpty()) { // Verifica se a lista é nula ou está vazia
                System.out.println("Não há empréstimos ativos.");
                return;
            }

            System.out.println("Empréstimos Ativos:");
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("Cliente: " + emprestimo.getCliente().getNome());
                System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Data de Empréstimo: " + emprestimo.getData_emp());
                System.out.println("Data de Devolução: " + emprestimo.getData_dev());
                System.out.println("------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar empréstimos: " + e.getMessage());
        }
    }

    // Método que exibe o menu de relatórios
    public static void exibirMenuRelatorio(List<Cliente> clientes, List<Livro> livros, List<Emprestimo> emprestimos) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha uma opção para exibir o relatório:");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Listar Livros");
            System.out.println("3. Listar Empréstimos Ativos");
            System.out.println("0. Sair");

            // Lê a opção do usuário
            int opcao = scanner.nextInt();
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
        } catch (Exception e) {
            System.out.println("Erro ao exibir o menu de relatórios: " + e.getMessage());
        }
    }
}
