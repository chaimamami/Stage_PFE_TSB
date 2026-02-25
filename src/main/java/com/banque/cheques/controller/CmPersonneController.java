package com.banque.cheques.controller;

import com.banque.cheques.entity.CmPersonne;
import com.banque.cheques.repository.CmPersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/personnes")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CmPersonneController {

    private final CmPersonneRepository repository;


    @GetMapping
    public List<CmPersonne> getAll() {

        return repository.findAll();

    }


    @GetMapping("/{id}")
    public CmPersonne getOne(@PathVariable String id) {

        return repository.findById(id).orElse(null);

    }



    @PostMapping
    public CmPersonne create(@RequestBody CmPersonne p) {

        if (p.getCodPer() != null)
            p.setCodPer(p.getCodPer().trim());

        if (p.getNomPer() != null)
            p.setNomPer(p.getNomPer().trim());


        p.setDatCre(new Date());

        return repository.save(p);

    }

}