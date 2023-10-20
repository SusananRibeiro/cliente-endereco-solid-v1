package com.cadastro.entitys;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "cliente")
@SQLDelete(sql = "UPDATE cliente SET delete_at = now() WHERE id=?") // para fazer o Soft-Delete, "now()" substitui pela data atual
@Where(clause = "delete_at is null") // vai criar uma nova coluna
public class Clientes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column
    private String sobrenome;
    @Column(nullable = false)
    private String email;
    private LocalDate dataNascimento;
    @Column(nullable = false)
    private String telefone;
    @Column
    private LocalDateTime deleteAt; // Soft Delete

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDelete_at(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }
}
