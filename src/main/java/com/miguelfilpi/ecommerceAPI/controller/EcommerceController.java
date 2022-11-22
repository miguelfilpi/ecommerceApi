package com.miguelfilpi.ecommerceAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.miguelfilpi.ecommerceAPI.modelo.Cliente;
import com.miguelfilpi.ecommerceAPI.modelo.Endereco;
import com.miguelfilpi.ecommerceAPI.repositories.Clientes;
import com.miguelfilpi.ecommerceAPI.servico.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class EcommerceController {
    @Autowired
    private CepService cepService;
    @Autowired
    private Clientes clienteRepository;

    @GetMapping("/CepService/{cep}")
    public String getCepInfo(@PathVariable final String cep) throws JsonProcessingException {
        System.out.printf("CepController - Buscando o CEP: " + cep);
        return cepService.getCepInfo(cep);
    }

    @PostMapping("/api/clientAddress")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Cliente cliente1 = new Cliente();
        if(clienteRepository.existsById(cliente.getEmail())) {
            Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getEmail());
            cliente1 = clienteOptional.orElseThrow();
            cliente1.getListaEnderecos().addAll(cliente.getListaEnderecos());
            clienteRepository.save(cliente1);
        } else {
            clienteRepository.save(cliente);
        }

      return new ResponseEntity<>(cliente,HttpStatus.CREATED);
    }

    @GetMapping("/api/clientAddress/{email}")
    public ResponseEntity<Optional<Cliente>> getAllById(@PathVariable String email){
        Optional<Cliente> allAddresses;
        try{
            allAddresses = clienteRepository.findById(email);
            return new ResponseEntity<>(allAddresses, HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
