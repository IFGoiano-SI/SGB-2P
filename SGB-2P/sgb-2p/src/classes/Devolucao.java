package classes;

public class Devolucao {
    private Livro livro;

    public Devolucao(Livro livro) {
        this.livro = livro;
    }

    public boolean realizarDevolucao() {
        try {
            if (livro.getExemplaresDisponiveis() < livro.getNumExemplares()) {
                livro.setNumExemplares(livro.getExemplaresDisponiveis() + 1);
                System.out.println("Livro devolvido com sucesso.");
                return true;
            } else {
                System.out.println("Todos os exemplares já estão disponíveis.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar a devolução: " + e.getMessage());
            return false;
        }
    }
}
