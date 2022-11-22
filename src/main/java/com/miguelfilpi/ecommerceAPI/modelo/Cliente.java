package com.miguelfilpi.ecommerceAPI.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private String email;
    @ElementCollection
    @Embedded
    private List<Endereco> listaEnderecos = new ArrayList<>();

    public Cliente(){}

    public Cliente(String email){
        this.email= email;
    }
    public String getEmail() {
        return email;
    }

    public Cliente(String email, List<Endereco>listaEnderecos){
        setEmail(email);
        setListaEnderecos(listaEnderecos);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }

    public void setListaEnderecos(List<Endereco> listaEnderecos) {
        this.listaEnderecos = listaEnderecos;
    }
}
