package io.github.spring_data_jpa_study.spring_data_jpa_study.dao;

import io.github.spring_data_jpa_study.spring_data_jpa_study.entity.Aluno;
import io.github.spring_data_jpa_study.spring_data_jpa_study.projection.AlunoArmarioProjection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AlunoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Aluno> findAllByNomeCompleto(String nome) {
        final String sqlQuery = "select a from tb_aluno a where a.nomeCompleto = :nome";
        return this.entityManager.createQuery(sqlQuery, Aluno.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Aluno> findByIdentifier(Long identificador) {
        final String sqlQuery = "select a from tb_aluno a where a.identificador = :identificador";
        return this.entityManager.createQuery(sqlQuery, Aluno.class)
                .setParameter("identificador", identificador)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Long getTotalElements(String dataInicio, String dataFim) {
        final String sqlQuery = "select count(1) from tb_aluno a where a.anoMatricula >= :dataInicio AND a.anoMatricula <= :dataFim";
        return this.entityManager.createQuery(sqlQuery, Long.class)
                .setParameter("dataInicio", dataInicio)
                .setParameter("dataFim", dataFim)
                .getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<Aluno> findAllByNomeLike(String nome) {
        nome = "%".concat(nome).concat("%");
        final String sqlQuery = "select a from tb_aluno a where a.nomeCompleto like :nome";
        return this.entityManager.createQuery(sqlQuery, Aluno.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public AlunoArmarioProjection findByNumeroArmario(String numeroArmario) {
        final String sqlQuery = "select new AlunoArmarioProjection(a.nomeCompleto, a.armario.numeroArmario, a.armario.detalheArmario) " +
                "from tb_aluno a where a.armario.numeroArmario = :numero_armario";
        return this.entityManager.createQuery(sqlQuery, AlunoArmarioProjection.class)
                .setParameter("numero_armario", numeroArmario)
                .getSingleResult();
    }


}
