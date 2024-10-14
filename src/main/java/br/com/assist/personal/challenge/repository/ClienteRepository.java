package br.com.assist.personal.challenge.repository;

import br.com.assist.personal.challenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
