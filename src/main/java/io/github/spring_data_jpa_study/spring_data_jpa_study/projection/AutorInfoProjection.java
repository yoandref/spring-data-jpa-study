package io.github.spring_data_jpa_study.spring_data_jpa_study.projection;

import lombok.Getter;

@Getter
public class AutorInfoProjection {

    private String nomeCompleto;
    private String cargo;
    private String bio;

    public AutorInfoProjection(String nome, String sobrenome, String cargo, String bio) {
        this.nomeCompleto = nome + " " + sobrenome;
        this.cargo = cargo;
        this.bio = bio;
    }
}
