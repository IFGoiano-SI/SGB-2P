import classes.Endereco;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
            try {
                System.out.print("Digite a opção desejada: ");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        System.out.println("Cadastrar novo livro");
                        menu = 0;
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
                    case 0:
                        System.out.println("Saindo...");
                        System.exit(0);
                        menu = 0;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Opção inválida, apenas opções numéricas são aceitas");
            }
        } while (menu != 0);

    }


}