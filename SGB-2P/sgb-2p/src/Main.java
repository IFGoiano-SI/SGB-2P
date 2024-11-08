import classes.Endereco;
import classes.Cliente;
import classes.Emprestimo;
import classes.Livro;
import classes.Relatorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    //array de 10 clientes
    static Cliente[] clientes = new Cliente[10];

    //array de 10 livros
    static Livro[] livros = new Livro[10];

    static Emprestimo[] emprestimos = new Emprestimo[10];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
                    System.out.print("Digite um número válido: ");
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
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um código válido: ");
            scanner.next();
        }
        int codigo = scanner.nextInt();
        scanner.nextLine();
        Livro livro = getLivro(codigo);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            scanner.nextLine();
            menu();
            return;
        }
        if (livro.getNumExemplares() == 0) {
            System.out.println("Livro indisponível!");
            scanner.nextLine();
            menu();
            return;
        }
        System.out.print("Digite o cpf do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = getCliente(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            scanner.nextLine();
            menu();
            return;
        }

        //verificar se o cliente já possui um emprestimo
        Emprestimo emprestimo = getEmprestimo(cliente);
        if (emprestimo != null) {
            System.out.println("Cliente já possui um emprestimo!");
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

    //CADASTRAR CLIENTE
    public static void cadastrarCliente() {
        try {
            System.out.println("\nCadastro de Cliente");
            //coletando dados do cliente
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();

            System.out.print("Digite o telefone do cliente: ");
            String telefone = scanner.nextLine();

            //coletando informações de endereço
            System.out.print("Digite a rua do endereço: ");
            String rua = scanner.nextLine();

            System.out.print("Digite o bairro do endereço: ");
            String bairro = scanner.nextLine();

            System.out.print("Digite a cidade do endereço: ");
            String cidade = scanner.nextLine();

            System.out.print("Digite o estado do endereço: ");
            String estado = scanner.nextLine();

            System.out.print("Digite o CEP do endereço (somente números): ");
            String cep = scanner.nextLine();

            int numero = 0;
            boolean numeroValido = false;

            //laço para garantir que o número do endereço seja válido
            while (!numeroValido) {
                try {
                    System.out.print("Digite o número do endereço: ");
                    numero = Integer.parseInt(scanner.nextLine());  //TEnta converter para int
                    numeroValido = true; //se não ocorrer erro, sai do loop
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido. Por favor, insira um número inteiro.");
                }
            }

            //cria objeto Endereco
            Endereco endereco = new Endereco(rua, bairro, cidade, estado, cep, numero);

            //cria o objeto Cliente
            Cliente cliente = new Cliente(nome, cpf, telefone, endereco);

            //procurando o primeiro índice vazio para armazenar o cliente
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] == null) {
                    clientes[i] = cliente;
                    System.out.println("Cliente cadastrado com sucesso!");
                    System.out.println(cliente.toString()); //exibe os dados do cliente cadastrado
                    scanner.nextLine();
                    menu();
                    return;
                }
            }

            System.out.println("Desculpe, não há espaço para mais clientes.");
        } catch (Exception e) {
            System.out.println("Não foi possível cadastrar o cliente");
            scanner.nextLine();
            menu();
        }
    }

    public static void exportarCSV() {
        try {
            //exportar todos os arrays para um arquivo CSV separado por ; e com quebra de linha
            //exemplo:
            //Livros
            //codigo;titulo;autor;anoPublicacao;numExemplares
            //1;titulo1;autor1;2021;10
            //2;titulo2;autor2;2020;5
            //Clientes
            //nome;cpf;telefone;endereco
            //cliente1;12345678901;123456789;rua1;bairro1;cidade1;estado1;cep1;numero1
            //cliente2;12345678902;123456789;rua2;bairro2;cidade2;estado2;cep2;numero2
            //Emprestimos
            //livro;cliente;data_emp;data_dev
            //1;cliente1;2021-01-01;2021-01-15
            //2;cliente2;2021-01-02;2021-01-16

            //pegar a data atual para adicionar no nome do arquivo
            //exemplo: 2021-01-01.csv
            //criar um arquivo com o nome da data atual

            LocalDate hoje = LocalDate.now();
            String nomeArquivo = "exportar-dados-"+hoje.toString() + ".csv";
            File arquivo = new File(nomeArquivo);
            //escrever no arquivo
            FileWriter fileWriter = new FileWriter(arquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //escrever os livros
            bufferedWriter.write("Livros;");
            bufferedWriter.newLine();
            bufferedWriter.write("codigo;titulo;autor;anoPublicacao;numExemplares;");
            bufferedWriter.newLine();
            for (Livro livro : livros) {
                if (livro != null) {
                    bufferedWriter.write(livro.getCodigo() + ";" + livro.getTitulo() + ";" + livro.getAutor() + ";" + livro.getAnoPublicacao() + ";" + livro.getNumExemplares()+";");
                    bufferedWriter.newLine();
                }
            }
            //escrever os clientes
            bufferedWriter.write("Clientes;");
            bufferedWriter.newLine();
            bufferedWriter.write("nome;cpf;telefone;endereco;");
            bufferedWriter.newLine();
            for (Cliente cliente : clientes) {
                if (cliente != null) {
                    bufferedWriter.write(cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getTelefone() + ";" + cliente.getEndereco().toString(' ') + ";");
                    bufferedWriter.newLine();
                }
            }

            //escrever os emprestimos
            bufferedWriter.write("Emprestimos");
            bufferedWriter.newLine();
            bufferedWriter.write("livro;cliente;data_emp;data_dev");
            bufferedWriter.newLine();
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo != null) {
                    bufferedWriter.write(emprestimo.getLivro().getCodigo() + ";" + emprestimo.getCliente().getCpf() + ";" + emprestimo.getData_emp() + ";" + emprestimo.getData_dev());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            System.out.println("Arquivo exportado com sucesso!");
            scanner.nextLine();
            menu();
        } catch (IOException e) {
            System.out.println("Erro ao exportar arquivo");
            scanner.nextLine();
            menu();
        } catch (Exception e) {
            System.out.println("Erro ao exportar arquivo");
            scanner.nextLine();
            menu();
        }
    }

    //menu
    public static void menu() {
        int menu = 1;
        //leiaute do menu
        //"layout"
        do {
            System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
            System.out.println("| Sistema Gerenciador de biblioteca |");
            System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
            System.out.println("| 1 - Cadastrar novo livro          |");
            System.out.println("| 2 - Cadastrar novo emprestimo     |");
            System.out.println("| 3 - Cadastrar novo cliente        |");
            System.out.println("| 4 - Devolver livro                |");
            System.out.println("| 5 - Excluir Livro                 |");
            System.out.println("| 6 - Excluir Cliente               |");
            System.out.println("| 7 - Relatorios...                 |");
            System.out.println("| 8 - Exportar .csv...              |");
            System.out.println("| 0 - Sair                          |");
            System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
            int opcao;
            System.out.print("Digite a opção desejada: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Deseja cadastrar um novo livro?");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Digite um número válido: ");
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
                        System.out.print("Digite um número válido: ");
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
                    System.out.println("Deseja cadastrar um novo cliente?");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Digite um número válido: ");
                        scanner.next();
                    }
                    int opc3 = scanner.nextInt();
                    scanner.nextLine();
                    if (opc3 == 1) {
                        cadastrarCliente();
                        return;
                    }
                    break;
                case 4:
                    System.out.println("Devolver livro");
                    menu = 0;
                    break;
                case 5:
                    System.out.println("Deseja excluir um livro?");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Digite um número válido: ");
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
                    System.out.println("Excluir livro");
                    removerCliente();
                    break;
                case 7:
                    System.out.println("Relatorios...");
                    try{
                        Relatorio.exibirMenuRelatorio(clientes, livros, emprestimos);
                    }catch (Exception e){
                        System.out.println("Erro ao exibir relatórios!");
                        scanner.nextLine();
                        menu();
                    }
                    break;
                case 8:
                    System.out.println("Exportar CSV");
                    exportarCSV();
                    return;
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


    public static void removerCliente() {
        System.out.print("Digite o CPF do cliente que deseja remover: ");
        String cpf = scanner.nextLine();
        Cliente clienteEncontrado = null;

        // Procurar o cliente pelo CPF
        for (Cliente cliente : clientes) {
            if (cliente == null) {
                continue;
            }
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.print("Deseja realmente remover o cliente " + clienteEncontrado.getNome() + "? (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                // Remover o cliente da lista
                for (int i = 0; i < clientes.length; i++) {
                    if (clientes[i] != null && clientes[i].getCpf().equals(cpf)) {
                        clientes[i] = null;
                        break;
                    }
                }
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
        scanner.nextLine();
    }

}   