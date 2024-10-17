package br.com.assist.personal.challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_FEEDBACK")//Tabela do banco de dados
@EntityListeners(AuditingEntityListener.class)
public class Feedback {

    @Id
    @GeneratedValue
    @Column(name = "ID_FEEDBACK")
    private Long id;

    @Min(1)
    @Column(name = "NOTA_FEEDBACK", nullable = false)
    private Integer nota;

    @Size(max = 255, min = 10)
    @NotBlank(message = "Feedback positivo é obrigatório")
    @Column(name = "POSITIVO_FEEDBACK", nullable = false, length = 255)
    private String positivo;

    @Size(max = 255, min = 10)
    @NotBlank(message = "Feedback negativo é obrigatório")
    @Column(name = "NEGATIVO_FEEDBACK", nullable = false, length = 255)
    private String negativo;
}
