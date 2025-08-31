package io.github.spring_data_jpa_study.spring_data_jpa_study.controller;

import io.github.spring_data_jpa_study.spring_data_jpa_study.dao.AutorDao;
import io.github.spring_data_jpa_study.spring_data_jpa_study.entity.Autor;
import io.github.spring_data_jpa_study.spring_data_jpa_study.entity.InfoAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorDao autorDao;

    @GetMapping("{id}")
    public Autor findById(@PathVariable Long id) {
        Autor autor = autorDao.findById(id);
        return autor;
    }

    @GetMapping
    public List<Autor> findAll() {
        List<Autor> autorList = autorDao.findAll();
        return autorList;
    }

    @GetMapping("nomeOrSobrenome")
    public List<Autor> findByNomeOuSobrenome(@RequestParam String termo) {
        List<Autor> autorList = autorDao.findAllByNomeOrSobrenome(termo);
        return autorList;
    }

    @GetMapping("total")
    public Long getTotalDeAutores() {
        return autorDao.getTotalElements();
    }

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

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        autorDao.delete(id);
    }

    @PutMapping("{id}/info")
    public Autor salvarInfoAUtor(@PathVariable Long id, @RequestBody InfoAutor infoAutor) {
        return autorDao.saveInfoAutor(infoAutor, id);
    }

}
