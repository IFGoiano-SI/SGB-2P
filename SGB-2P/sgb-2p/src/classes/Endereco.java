package classes;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private int numero;
    private String complemento;

    public Endereco(String rua, String bairro, String cidade, String estado, String cep, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
    }

    public Endereco(String rua, String bairro, String cidade, String estado, String cep, int numero, String complemento) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    String getEndereco() {
        // Retorna uma string com todos os dados da classe já formatados
        String retorno = "";
        retorno += "Rua: " + this.rua + "\n";
        retorno += "Bairro: " + this.bairro + "\n";
        retorno += "Cidade: " + this.cidade + "\n";
        retorno += "Estado: " + this.estado + "\n";
        retorno += "CEP: " + this.cep + "\n";
        retorno += "Número: " + this.numero + "\n";
        // Se o complemento não for nulo, é adicionado ao retorno
        if (this.complemento != null) {
            retorno += "Complemento: " + this.complemento + "\n";
        }
        return retorno;
    }

}
