package classes;

public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numExemplares;
    private int exemplaresDisponiveis;

    public Livro(int codigo, String titulo, String autor, int anoPublicacao, int numExemplares) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numExemplares = numExemplares;
        this.exemplaresDisponiveis = numExemplares;
    }

    public int getCodigo() {
        return codigo;
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

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumExemplares() {
        return numExemplares;
    }

    public void setNumExemplares(int numExemplares) {
        this.numExemplares = numExemplares;
        this.exemplaresDisponiveis = numExemplares;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public String getDadosLivro() {
        String retorno = "Título: " + this.titulo + "\n";
        retorno += "Autor: " + this.autor + "\n";
        retorno += "Ano de Publicação: " + this.anoPublicacao + "\n";
        retorno += "Número de Exemplares: " + this.numExemplares + "\n";
        retorno += "Exemplares Disponíveis: " + this.exemplaresDisponiveis + "\n";
        return retorno;
    }

    public boolean emprestar() {
        if (this.exemplaresDisponiveis > 0) {
            this.exemplaresDisponiveis--;
            return true;
        } else {
            return false;
        }
    }

    public boolean devolver() {
        if (this.exemplaresDisponiveis < this.numExemplares) {
            this.exemplaresDisponiveis++;
            return true;
        } else {
            return false;
        }
    }
}
