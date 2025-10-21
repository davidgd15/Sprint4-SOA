package com.fiap.sprint4.service;

import com.fiap.sprint4.domain.cliente.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente create(Cliente c);
    List<Cliente> list();
    Cliente get(Long id);
    Cliente update(Long id, Cliente c);
    void delete(Long id);
}