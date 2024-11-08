package classes;

public class Endereco {
    public String rua;
    public String bairro;
    public String cidade;
    public String estado;
    private String cep;
    private int numero;
    public String complemento;

    //construtor sem uso do complemento
    public Endereco(String rua, String bairro, String cidade, String estado, String cep, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
    }

    //construtor com uso do complemento deixando-o opcional
    public Endereco(String rua, String bairro, String cidade, String estado, String cep, int numero, String complemento) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Rua: " + this.rua + "\n" +
                "Bairro: " + this.bairro + "\n" +
                "Cidade: " + this.cidade + "\n" +
                "Estado: " + this.estado + "\n" +
                "CEP: " + this.cep + "\n" +
                "Número: " + this.numero + "\n" +
                (this.complemento != null ? "Complemento: " + this.complemento + "\n" : "");
    }
    public String toString(char separador) {
        return this.rua + separador + this.bairro + separador + this.cidade + separador + this.estado + separador + this.cep + separador + this.numero + separador + (this.complemento != null ? this.complemento : "");
    }


    public Boolean setCep(String cep) {
        //permitir apenas CEPs com 8 digitos Ex: 00000-000
        if (cep.length() == 8) {
            this.cep = cep;
            return true;
        } else {
            return false;
        }
    }


}
