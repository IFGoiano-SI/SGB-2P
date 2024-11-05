package classes;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private String isbn;
    private boolean disponivel;

    public Livro (String titulo, String autor, String editora, int anoPublicacao, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getDadosLivro() {
        String retorno = "Título: " + this.titulo + "\n";
        retorno += "Autor: " + this.autor + "\n";
        retorno += "Editora: " + this.editora + "\n";
        retorno += "Ano de Publicação: " + this.anoPublicacao + "\n";
        retorno += "ISBN: " + this.isbn + "\n";
        retorno += "Disponível: " + (this.disponivel ? "Sim" : "Não") + "\n";
        return retorno;
    }

    public void emprestar() {
        if (this.disponivel) {
            this.disponivel = false;
            System.out.println("Sucesso ao realizar o emprestimo do livro!");
        } else {
            System.out.println("Sinto muito, este livro já foi emprestado a outro cliente.");
        }
    }

    public void devolver() {
        if (!this.disponivel) {
            this.disponivel = true;
            System.out.println("Sucesso ao devolver o livro!");
        } else {
            System.out.println("Este livro já está disponivel novamente para emprestimo!");
        }
    }
}