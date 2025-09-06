package io.github.spring_data_jpa_study.spring_data_jpa_study.projection;

import lombok.Getter;

@Getter
public class AlunoArmarioProjection {

    private String nomeAluno;
    private String numeroArmario;
    private String detalheArmario;

    public AlunoArmarioProjection(String nomeAluno, String numeroArmario, String detalheArmario) {
        this.nomeAluno = nomeAluno;
        this.numeroArmario = numeroArmario;
        this.detalheArmario = detalheArmario;
    }
}
