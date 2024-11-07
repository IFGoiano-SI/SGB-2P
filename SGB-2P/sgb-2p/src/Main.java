import classes.Endereco;
import classes.Cliente;
import classes.Emprestimo;
import classes.Livro;

import java.util.Scanner;


public class Main {

    //array de 5 clientes
    static Cliente[] clientes = new Cliente[5];
    //array de 10 livros
    static Livro[] livros = new Livro[10];

    static Emprestimo[] emprestimos = new Emprestimo[10];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //inicializar o sistema
        Endereco end = new Endereco("Rua 1", "Bairro 1", "Cidade 1", "Estado 1", "76350000", 743);
        Cliente cliente = new Cliente("Cliente 1", "12345678901", "123456789", end);
        clientes[0] = cliente;
        menu();
    }

    public static Livro getLivro(int codigo) {
        for (Livro livro : livros) {
            //percorrer o array de livros e verificar se o livro existe, se existir retornar o livro
            if (livro != null && livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }

    public static Cliente getCliente(String cpf) {
        for (Cliente cliente : clientes) {
            //percorrer o array de clientes e verificar se o cliente existe, se existir retornar o cliente
            if (cliente != null && cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static Emprestimo getEmprestimo(Cliente cliente) {
        for (Emprestimo emprestimo : emprestimos) {
            //percorrer o array de emprestimos e verificar se o emprestimo existe, se existir retornar o emprestimo
            if (emprestimo != null && emprestimo.getCliente().equals(cliente)) {
                return emprestimo;
            }
        }
        return null;
    }

    //Metodo para exclusão de livros;
    public static void excluirLivro() {
        System.out.println("Digite o código do livro que deseja excluir: ");
        //Scanner esperando um inteiro ser submetido pelo usuario impedindo que o programa quebre;
        while (!scanner.hasNextInt()) {
            System.out.println("Digite um número válido");
            scanner.next();
        }
        int codigo = scanner.nextInt();
        scanner.nextLine();
        //Verificação se o livro existe dentro do array;
        for (int i = 0; i < livros.length; i++) {
            //Se o livro existir dentro do array, seguirá o protocolo especificado;
            if (livros[i] != null && livros[i].getCodigo() == codigo) {
                System.out.println("Deseja mesmo apagar o livro? (1 = Sim, 0 = Não)");
                while (!scanner.hasNextInt()) {
                    System.out.println("Digite um número válido");
                    scanner.next();
                }
                //Scanneia o inteiro submetido pelo usuario;
                int opcao = scanner.nextInt();
                scanner.nextLine();
                //se a opção for correspondente a 1 (sim) seguira com o protocolo indicado;
                if (opcao == 1) {
                    //substituindo o livro na posição especifica por null
                    livros[i] = null;
                    System.out.println("Livro excluido com sucesso!");
                    //Scanner esperando a tecla "Enter" ser pressionada para retornar ao menu;
                    scanner.nextLine();
                    //retorno para o menu;
                    menu();
                    return;
                }
                menu();
                return;
            }
        }
        System.out.println("Livro não encontrado!");
        scanner.nextLine();
        menu();
    }

    public static void emprestarLivro() {
        //emprestar livro
        System.out.println("Emprestar livro");
        System.out.print("Digite o código do livro: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Livro livro = getLivro(codigo);
        if (livro == null) {
            System.out.println("Livro não encontrado");
            scanner.nextLine();
            menu();
            return;
        }
        if (livro.getNumExemplares() == 0) {
            System.out.println("Livro indisponível");
            scanner.nextLine();
            menu();
            return;
        }
        System.out.print("Digite o cpf do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = getCliente(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado");
            scanner.nextLine();
            menu();
            return;
        }

        //verificar se o cliente já possui um emprestimo
        Emprestimo emprestimo = getEmprestimo(cliente);
        if (emprestimo != null) {
            System.out.println("Cliente já possui um emprestimo");
            scanner.nextLine();
            menu();
            return;
        }

        System.out.print("Digite a data de empréstimo: ");
        String dataEmp = scanner.nextLine();
        System.out.print("Digite a data de devolução: ");
        String dataDev = scanner.nextLine();
        scanner.nextLine();
        for (int i = 0; i < emprestimos.length; i++) {
            if (emprestimos[i] == null) {
                Emprestimo novoEmprestimo = new Emprestimo(livro, cliente, dataEmp, dataDev);

                emprestimos[i] = novoEmprestimo;
                for (Livro l : livros) {
                    if (l != null && l.getCodigo() == livro.getCodigo()) {
                        if (l.emprestar()) {
                            System.out.println("Livro emprestado com sucesso!");
                        } else {
                            System.out.println("Não foi possível emprestar o livro");
                            emprestimos[i] = null;
                        }
                    }
                }

                break;
            }
        }
        menu();
    }

    public static void cadastrarLivro() {
        //cadastrar novo livro
        System.out.println("Cadastrar novo livro");
        //percorrer o array de livros e verificar se há espaço
        int cadastrar = 1;
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                //cadastrar novo livro
                try {
                    System.out.print("Digite o código do livro: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Digite um código válido");
                        scanner.next();
                    }
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    //verificar se o código do livro já existe
                    if (getLivro(codigo) != null) {
                        System.out.println("Livro já cadastrado");
                        scanner.nextLine();
                        menu();
                        return;
                    }
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação do livro: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Digite um ano válido");
                        scanner.next();
                    }
                    int anoPublicacao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o número de exemplares do livro: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Digite um número válido");
                        scanner.next();
                    }
                    int numExemplares = scanner.nextInt();
                    scanner.nextLine();
                    Livro livro = new Livro(codigo, titulo, autor, anoPublicacao, numExemplares);

                    livros[i] = livro;
                    System.out.println("Livro cadastrado com sucesso!");

                    cadastrar = 0;
                } catch (Exception e) {
                    System.out.println("Não foi possivel cadastrar o livro");
                    scanner.nextLine();
                    menu();
                    return;
                }
                break;
            }
        }
        if (cadastrar == 1) {
            System.out.println("Não há espaço para cadastrar um novo livro");
        }
        scanner.nextLine();
        menu();
    }

    //menu
    public static void menu() {
        int menu = 1;
        //leiaute do menu
        //"layout"
        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("| Sistema Gerenciador de biblioteca |");
        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("| 1 - Cadastrar novo livro          |");
        System.out.println("| 2 - Cadastrar novo emprestimo     |");
        System.out.println("| 3 - Cadastrar novo cliente        |");
        System.out.println("| 4 - Devolver livro                |");
        System.out.println("| 5 - Excluir Livro                 |");
        System.out.println("| 6 - Relatorios...                 |");
        System.out.println("| 0 - Sair                          |");
        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        do {
            int opcao;
            System.out.print("Digite a opção desejada: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um número válido");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Deseja cadastrar um novo livro?");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Digite um número válido");
                        scanner.next();
                    }
                    int opc = scanner.nextInt();
                    scanner.nextLine();
                    if (opc == 1) {
                        cadastrarLivro();
                        return;
                    }
                    break;
                case 2:
                    System.out.println("Deseja cadastrar um novo emprestimo?");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Digite um número válido");
                        scanner.next();
                    }
                    int opc2 = scanner.nextInt();
                    scanner.nextLine();
                    if (opc2 == 1) {
                        emprestarLivro();
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Cadastrar novo cliente");
                    menu = 0;
                    break;
                case 4:
                    System.out.println("Devolver livro");
                    menu = 0;
                    break;
                case 5:
                    System.out.println("Deseja excluir um livro?");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Digite um número válido");
                        scanner.next();
                    }
                    int opc5 = scanner.nextInt();
                    scanner.nextLine();
                    if (opc5 == 1) {
                        excluirLivro();
                        return;
                    }
                    break;
                case 6:
                    System.out.println("Relatorios...");
                    menu = 0;
                    break;
                case 9:
                    System.out.println("Saindo...");
                    System.exit(0);
                    menu = 0;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (menu != 0);

    }


}
