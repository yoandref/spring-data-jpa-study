package io.github.spring_data_jpa_study.spring_data_jpa_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "tb_armario")
@Table(name = "tb_armario")
public class Armario implements Serializable {

    @Id
    @Column(name = "numero_armario")
    private String numeroArmario;

    @Column(name = "detalhe_armario")
    private String detalheArmario;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Armario armario = (Armario) o;
        return Objects.equals(numeroArmario, armario.numeroArmario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroArmario);
    }
}
