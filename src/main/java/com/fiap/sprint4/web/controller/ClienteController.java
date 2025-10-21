package com.fiap.sprint4.web.controller;

import com.fiap.sprint4.domain.cliente.Cliente;
import com.fiap.sprint4.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Swagger/OpenAPI
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/api/clientes", produces = "application/json")
@Tag(name = "Clientes", description = "CRUD de clientes")
public class ClienteController {

    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @Operation(summary = "Lista todos os clientes")
    @GetMapping
    public List<Cliente> list() {
        return service.list();
    }

    @Operation(summary = "Busca cliente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id) {
        return service.get(id);
    }

    @Operation(summary = "Cria um novo cliente")
    @ApiResponse(responseCode = "201", description = "Criado")
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody @Valid Cliente c) {
        return service.create(c);
    }

    @Operation(summary = "Atualiza um cliente existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Atualizado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @PutMapping(value = "/{id}", consumes = "application/json")
    public Cliente update(@PathVariable Long id, @RequestBody @Valid Cliente c) {
        return service.update(id, c);
    }

    @Operation(summary = "Remove um cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Removido"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
