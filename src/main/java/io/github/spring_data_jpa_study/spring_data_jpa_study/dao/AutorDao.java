package io.github.spring_data_jpa_study.spring_data_jpa_study.dao;

import io.github.spring_data_jpa_study.spring_data_jpa_study.entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
