package com.grupo11;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Ticket {
    @Id
    @SequenceGenerator(
            name = "id_ticket",
            sequenceName = "id_ticket",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_ticket"
    )
    private Integer id;
    private String nomeSolicitante;
    private String descricao;
    private String endereco;
    private String status;

    public Ticket(Integer id, String nomeSolicitante, String descricao, String endereco, String status) {
        this.id = id;
        this.nomeSolicitante = nomeSolicitante;
        this.descricao = descricao;
        this.endereco = endereco;
        this.status = status;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(nomeSolicitante, ticket.nomeSolicitante) && Objects.equals(descricao, ticket.descricao) && Objects.equals(endereco, ticket.endereco) && Objects.equals(status, ticket.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeSolicitante, descricao, endereco, status);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", nomeSolicitante='" + nomeSolicitante + '\'' +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
