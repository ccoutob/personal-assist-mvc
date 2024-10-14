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
@Table(name = "TB_CLIENTE")//Tabela do banco de dados
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

        //Chave Primária
        @Id
        @GeneratedValue
        @Column(name = "ID_CLIENTE")
        private Long codigo;

        //Coluna da tabela
        @Column(name = "NM_CLIENTE", length = 100, nullable = false)
        private String nome;

        //Coluna da tabela
        @Column(name = "DS_EMAIL", length = 100, nullable = false)
        private String email;

        ////Coluna da tabela
        @Column(name = "NR_CPF", length = 30, unique = true, nullable = false)
        private String cpf;
}
