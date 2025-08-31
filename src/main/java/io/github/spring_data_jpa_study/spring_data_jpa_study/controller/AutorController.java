package io.github.spring_data_jpa_study.spring_data_jpa_study.controller;

import io.github.spring_data_jpa_study.spring_data_jpa_study.dao.AutorDao;
import io.github.spring_data_jpa_study.spring_data_jpa_study.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorDao autorDao;

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        autorDao.save(autor);
        return autor;
    }

    @PutMapping
    public Autor atualizar(@RequestBody Autor autor) {
        autorDao.update(autor);
        return autor;
    }

}
