package br.com.assist.personal.challenge.model;

import jakarta.persistence.*;
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

    @Column(name = "MED_CRESCIMENTO")
    private Integer mediaCrescimento; //Em porcentagem

    @Column(name = "TAX_CRESC_MES")
    private Integer crescimentoMensal; //Em porcentagem

    @Column(name = "RECEITA_LIQ")
    private Integer receita;

    @Column(name = "ANALISE_DESC", length = 500)
    private String analise;
}
