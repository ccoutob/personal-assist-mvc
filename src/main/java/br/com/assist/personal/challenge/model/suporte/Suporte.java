package br.com.assist.personal.challenge.model.suporte;

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
@Table(name = "TB_SUPORTE")
@EntityListeners(AuditingEntityListener.class)
public class Suporte {

    @Id
    @GeneratedValue
    @Column(name = "ID_SUPORTE")
    private Long codigo;

    @Column(name = "DESC_PROBLEMA", length = 255, nullable = false)
    private String descricao;

    @Column(name = "STAT_TICKET", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTicket status;
}