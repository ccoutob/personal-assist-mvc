package br.com.assist.personal.challenge.repository;

import br.com.assist.personal.challenge.model.Estatistica;
import br.com.assist.personal.challenge.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
