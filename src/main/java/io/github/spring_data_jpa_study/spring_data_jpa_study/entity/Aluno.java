package io.github.spring_data_jpa_study.spring_data_jpa_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "tb_aluno")
@Table(name = "tb_aluno")
public class Aluno implements Serializable {

    @Id
    @Column(name = "identificador", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long identificador;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "ano_letivo")
    private String anoLetivo;

    @Column(name = "ano_matricula")
    private String anoMatricula;


    @JoinColumn(name = "numero_armario")
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Armario armario;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(identificador, aluno.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identificador);
    }
}
