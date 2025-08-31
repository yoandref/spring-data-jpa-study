package io.github.spring_data_jpa_study.spring_data_jpa_study.dao;

import io.github.spring_data_jpa_study.spring_data_jpa_study.entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void save(Autor autor) {
        this.manager.persist(autor);
    }

    @Transactional
    public void update(Autor autor) {
        this.manager.merge(autor);
    }

    @Transactional
    public void delete(Long id) {
        this.manager.remove(this.manager.getReference(Autor.class, id));
    }

    @Transactional(readOnly = true)
    public Autor findById(Long id) {
        Autor autor = this.manager.find(Autor.class, id);
        return autor;
    }

    @Transactional(readOnly = true)
    public List<Autor> findAll() {
        String sqlQuery = "select a from Autor a";
        return this.manager.createQuery(sqlQuery, Autor.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Autor> findAllByNomeOrSobrenome(String termo) {
        final String sqlQuery = "select a from Autor a where a.nome like :termo OR a.sobrenome like :termo";
        final String parametro = "%".concat(termo).concat("%");
        return this.manager.createQuery(sqlQuery, Autor.class).setParameter("termo", parametro).getResultList();
    }
}
