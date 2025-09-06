package io.github.spring_data_jpa_study.spring_data_jpa_study.controller;

import io.github.spring_data_jpa_study.spring_data_jpa_study.dao.AlunoDao;
import io.github.spring_data_jpa_study.spring_data_jpa_study.entity.Aluno;
import io.github.spring_data_jpa_study.spring_data_jpa_study.projection.AlunoArmarioProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoDao alunoDao;

    //exercicio 1
    @GetMapping("/nome/{fullName}")
    public List<Aluno> selecionaAlunoPorNome(@PathVariable String fullName) {
        return alunoDao.findAllByNomeCompleto(fullName);
    }

    //exercicio 2
    @GetMapping("/matricula/{identificador}")
    public List<Aluno> selecionaAlunoPorIdentificador(@PathVariable Long identificador) {
        return alunoDao.findByIdentifier(identificador);
    }

    //exercicio 3
    @GetMapping("matricula")
    public Long selecionaQuantidadePorMatricula(@RequestParam(name = "dataInicio") String dataInicio,
                                                @RequestParam(name = "dataFim") String dataFim) {
        return alunoDao.getTotalElements(dataInicio, dataFim);
    }

    //exercicio 4
    @GetMapping("nome-parcial")
    public List<Aluno> selecionaPorNomeParcial(@RequestParam(name = "nomeParcial") String nomeParcial) {
        return alunoDao.findAllByNomeLike(nomeParcial);
    }

    //exercicio 5
    @GetMapping("armario/{numero-armario}")
    public AlunoArmarioProjection selecionaAlunoPorCodigoArmario(@PathVariable(name = "numero-armario") String numeroArmario) {
        return alunoDao.findByNumeroArmario(numeroArmario);
    }

}
