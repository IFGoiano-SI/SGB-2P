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
        try {
            this.titulo = titulo;
        } catch (Exception e) {
            System.out.println("Erro ao definir o título: " + e.getMessage());
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        try {
            this.autor = autor;
        } catch (Exception e) {
            System.out.println("Erro ao definir o autor: " + e.getMessage());
        }
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        try {
            this.anoPublicacao = anoPublicacao;
        } catch (Exception e) {
            System.out.println("Erro ao definir o ano de publicação: " + e.getMessage());
        }
    }

    public int getNumExemplares() {
        return numExemplares;
    }

    public void setNumExemplares(int numExemplares) {
        try {
            this.numExemplares = numExemplares;
            this.exemplaresDisponiveis = numExemplares;
        } catch (Exception e) {
            System.out.println("Erro ao definir o número de exemplares: " + e.getMessage());
        }
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public String getDadosLivro() {
        try {
            String retorno = "Título: " + this.titulo + "\n";
            retorno += "Autor: " + this.autor + "\n";
            retorno += "Ano de Publicação: " + this.anoPublicacao + "\n";
            retorno += "Número de Exemplares: " + this.numExemplares + "\n";
            retorno += "Exemplares Disponíveis: " + this.exemplaresDisponiveis + "\n";
            return retorno;
        } catch (Exception e) {
            System.out.println("Erro ao obter os dados do livro: " + e.getMessage());
            return null;
        }
    }

    public String toString(String delimitador) {
        try {
            return "Código: " + codigo + delimitador +
                    "Título: " + titulo + delimitador +
                    "Autor: " + autor + delimitador +
                    "Ano de Publicação: " + anoPublicacao + delimitador +
                    "Número de Exemplares: " + numExemplares + delimitador +
                    "Exemplares Disponíveis: " + exemplaresDisponiveis;
        } catch (Exception e) {
            System.out.println("Erro ao exportar os dados do livro: " + e.getMessage());
            return null;
        }
    }

    public boolean emprestar() {
        try {
            if (this.exemplaresDisponiveis > 0) {
                this.exemplaresDisponiveis--;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar o empréstimo: " + e.getMessage());
            return false;
        }
    }

    public boolean devolverLivro() {
        try {
            if (this.exemplaresDisponiveis < this.numExemplares) {
                this.exemplaresDisponiveis++;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar a devolução: " + e.getMessage());
            return false;
        }
    }
}
