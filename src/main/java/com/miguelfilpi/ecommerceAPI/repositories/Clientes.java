package com.miguelfilpi.ecommerceAPI.repositories;

import com.miguelfilpi.ecommerceAPI.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Clientes extends JpaRepository<Cliente, String> {
}
