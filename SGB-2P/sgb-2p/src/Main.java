import classes.Cliente;
import classes.Livro;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;


public class Main {

    //array de 5 clientes
    static Cliente[] clientes = new Cliente[5];
    //array de 10 livros
    static Livro[] livros = new Livro[10];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static Livro getLivro(int codigo){
        for (Livro livro : livros) {
            //percorrer o array de livros e verificar se o livro existe, se existir retornar o livro
            if (livro != null && livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
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
                    int codigo = Integer.parseInt(scanner.nextLine());
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
                    int anoPublicacao = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o número de exemplares do livro: ");
                    int numExemplares = Integer.parseInt(scanner.nextLine());
                    Livro livro = new Livro(codigo, titulo, autor, anoPublicacao, numExemplares);
                    if (livro != null) {
                        livros[i] = livro;
                        System.out.println("Livro cadastrado com sucesso!");
                    }
                    cadastrar = 0;
                }catch (Exception e){
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
        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("| Sistema Gerenciador de biblioteca |");
        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        System.out.println("| 1 - Cadastrar novo livro          |");
        System.out.println("| 2 - Cadastrar novo emprestimo     |");
        System.out.println("| 3 - Cadastrar novo cliente        |");
        System.out.println("| 4 - Devolver livro                |");
        System.out.println("| 5 - Relatorios...                 |");
        System.out.println("| 0 - Sair                          |");
        System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
        do {
            int opcao = 0;
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
                    int opc = Integer.parseInt(scanner.nextLine());
                    if (opc == 1) {
                        cadastrarLivro();
                        return;
                    }
                    break;
                case 2:
                    System.out.println("Cadastrar novo emprestimo");
                    menu = 0;
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