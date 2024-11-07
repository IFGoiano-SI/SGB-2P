
    public static void cadastrarCliente() {
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
                return; //retorna após o cadastro
            }
        }

        System.out.println("Desculpe, não há espaço para mais clientes.");
    }

