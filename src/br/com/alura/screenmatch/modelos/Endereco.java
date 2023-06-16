package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Endereco {

    private String rua;

    private String bairro;

    private int numero;

    private String complemento;

    private String cep;


    public Endereco(String rua, String bairro, int numero, String complemento, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Endereco(EnderecoViaCep enderecoViaCep) {
        this.rua = enderecoViaCep.logradouro();
        this.bairro = enderecoViaCep.bairro();
        this.complemento = enderecoViaCep.complemento();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
