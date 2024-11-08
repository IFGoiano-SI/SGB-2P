package classes;

import java.util.Scanner;

public class Relatorio {

    // Método para listar clientes
    public static void listarClientes(Cliente[] clientes) {
        try {
            Boolean vazio = true;

            for (Cliente cliente : clientes) {
                if(cliente == null) {
                    continue;
                }
                vazio = false;
                System.out.println("------------------------------------------------");
                System.out.println("Clientes Cadastrados:");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Endereço: " + cliente.getEndereco().toString('\t'));
                System.out.println("------------------------------------------------");
            }
            if (vazio) {
                System.out.println("Não há clientes cadastrados.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    // Método para listar livros
    public static void listarLivros(Livro[] livros) {
        try {
            if (livros == null || livros.length == 0) { // Verifica se lista é nula ou está vazia
                System.out.println("Não há livros cadastrados.");
                return;
            }

            System.out.println("Livros Cadastrados:");
            for (Livro livro : livros) {
                if (livro == null) {
                    continue;
                }
                System.out.println(livro.getDadosLivro());
                System.out.println("------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
    }

    // Método para listar empréstimos ativos
    public static void listarEmprestimos(Emprestimo[] emprestimos) {
        try {
            if (emprestimos == null || emprestimos.length == 0) { // Verifica se a lista é nula ou está vazia
                System.out.println("Não há empréstimos ativos.");
                return;
            }

            System.out.println("Empréstimos Ativos:");
            for (Emprestimo emprestimo : emprestimos) {
                if(emprestimo == null) {
                    continue;
                }
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
    public static void exibirMenuRelatorio(Cliente[] clientes, Livro[] livros, Emprestimo[] emprestimos) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha uma opção para exibir o relatório:");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Listar Livros");
            System.out.println("3. Listar Empréstimos Ativos");
            System.out.println("0. Sair");

            // Lê a opção do usuário
            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número.");
                scanner.next();
            }
            int opcao = scanner.nextInt();
            scanner.nextLine();
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
