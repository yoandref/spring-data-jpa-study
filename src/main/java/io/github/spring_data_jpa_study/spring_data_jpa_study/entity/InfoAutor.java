package io.github.spring_data_jpa_study.spring_data_jpa_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "info_autores")
public class InfoAutor implements Serializable {

    @Id
    @Column(name = "id_info", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "cargo", length = 45, nullable = false)
    private String cargo;

    @Column(name = "bio", length = 255, nullable = false)
    private String bio;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InfoAutor infoAutor = (InfoAutor) o;
        return Objects.equals(id, infoAutor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
