package com.miguelfilpi.ecommerceAPI.servico;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    @Value("${servico.online}")
    private String servicoOnline;


    public String getCepInfo(final String cep) throws JsonProcessingException {
        final var restTemplate = new RestTemplate();
        final var response =  restTemplate.getForObject(getUrl(cep), String.class);
        System.out.println(servicoOnline);
        return response;
    }


    private String getUrl(String cep){
        if ("viacep".equalsIgnoreCase(servicoOnline)) {
            return "https://viacep.com.br/ws/"+ cep + "/json";
        }
        return "https://api.postmon.com.br/v1/cep/" + cep;
    }



}
