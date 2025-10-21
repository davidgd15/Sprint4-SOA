package com.fiap.sprint4.domain.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "SPRINT4_CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 150)
    private String nome;

    @Email
    @Size(max = 150)
    private String email;

    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @Min(0)
    @Max(120)
    private Integer idade;

    // Construtor vazio (obrigatório para JPA)
    public Cliente() {
    }

    // Construtor completo (útil para testes)
    public Cliente(Long id, String nome, String email, String cpf, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters e Setters manuais
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}