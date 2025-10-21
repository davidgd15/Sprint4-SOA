package com.fiap.sprint4.service;

import com.fiap.sprint4.domain.cliente.Cliente;
import com.fiap.sprint4.exception.NotFoundException;
import com.fiap.sprint4.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repo;

    @Autowired
    public ClienteServiceImpl(ClienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public Cliente create(Cliente c) {
        return repo.save(c);
    }

    @Override
    public List<Cliente> list() {
        return repo.findAll();
    }

    @Override
    public Cliente get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    @Override
    public Cliente update(Long id, Cliente c) {
        Cliente cli = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
        cli.setNome(c.getNome());
        cli.setEmail(c.getEmail());
        cli.setCpf(c.getCpf());
        cli.setIdade(c.getIdade());
        return repo.save(cli);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Cliente não encontrado");
        }
        repo.deleteById(id);
    }
}