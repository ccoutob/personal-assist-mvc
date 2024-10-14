package br.com.assist.personal.challenge.repository;

import br.com.assist.personal.challenge.model.Estatistica;
import br.com.assist.personal.challenge.model.suporte.Suporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuporteRepository extends JpaRepository<Suporte, Long> {
}
