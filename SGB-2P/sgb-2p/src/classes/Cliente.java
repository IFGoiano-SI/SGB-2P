package classes;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;

    public Cliente(String nome, String cpf, String telefone, Endereco endereco) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome não pode ser vazio");
            }
            if (cpf == null || cpf.isEmpty()) {
                throw new IllegalArgumentException("CPF não pode ser vazio");
            }
            if (telefone == null || telefone.isEmpty()) {
                throw new IllegalArgumentException("Telefone não pode ser vazio");
            }

            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.endereco = endereco;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no construtor: " + e.getMessage());
        }
    }

    // Getters e setters para os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome não pode ser vazio");
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir nome: " + e.getMessage());
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        try {
            if (cpf == null || cpf.isEmpty()) {
                throw new IllegalArgumentException("CPF não pode ser vazio");
            }
            this.cpf = cpf;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir CPF: " + e.getMessage());
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        try {
            if (telefone == null || telefone.isEmpty()) {
                throw new IllegalArgumentException("Telefone não pode ser vazio");
            }
            this.telefone = telefone;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir telefone: " + e.getMessage());
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
