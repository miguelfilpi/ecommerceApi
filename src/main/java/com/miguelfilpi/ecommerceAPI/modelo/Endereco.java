package com.miguelfilpi.ecommerceAPI.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    @Column
    private String logradouro;
    @Column
    private String bairro;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column
    private String CEP;

    public Endereco(){

    }

    public Endereco(String logradouro, String bairro, String cidade, String estado, String cep) {
        setLogradouro(logradouro);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
        setCEP(cep);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
