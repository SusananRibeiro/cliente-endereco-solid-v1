package com.cadastro.useCases.clientes.impl.repository;
import com.cadastro.entitys.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
