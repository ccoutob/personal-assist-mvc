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
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_ESTATISTICA")
@EntityListeners(AuditingEntityListener.class)
public class Estatistica {

    @Id
    @GeneratedValue
    @Column(name = "ID_ESTATISTICA")
    private Long id;

    @Min(1)
    @Column(name = "MED_CRESCIMENTO")
    private Integer mediaCrescimento; //Em porcentagem

    @Min(1)
    @Column(name = "TAX_CRESC_MES")
    private Integer crescimentoMensal; //Em porcentagem

    @Min(1)
    @Column(name = "RECEITA_LIQ")
    private Integer receita;

    @Size(max = 500, min = 10)
    @NotBlank(message = "Análise é obrigatório")
    @Column(name = "ANALISE_DESC", length = 500)
    private String analise;
}
