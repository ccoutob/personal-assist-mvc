package br.com.assist.personal.challenge.repository;

import br.com.assist.personal.challenge.model.Estatistica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {
}
