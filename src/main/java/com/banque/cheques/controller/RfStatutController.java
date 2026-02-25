package com.banque.cheques.controller;

import com.banque.cheques.entity.RfStatut;
import com.banque.cheques.repository.RfStatutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rf-statuts")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class RfStatutController {

    private final RfStatutRepository repository;

    @GetMapping
    public List<RfStatut> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{codSta}")
    public RfStatut getOne(@PathVariable String codSta) {
        return repository.findById(codSta).orElse(null);
    }

    @PostMapping
    public RfStatut create(@RequestBody RfStatut statut) {
        if (statut.getCodSta() != null) statut.setCodSta(statut.getCodSta().trim());
        if (statut.getLibSta() != null) statut.setLibSta(statut.getLibSta().trim());
        return repository.save(statut);
    }
}