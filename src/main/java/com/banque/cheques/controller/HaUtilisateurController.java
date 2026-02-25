package com.banque.cheques.controller;

import com.banque.cheques.entity.HaUtilisateur;
import com.banque.cheques.repository.HaUtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class HaUtilisateurController {

    private final HaUtilisateurRepository repository;

    @GetMapping
    public List<HaUtilisateur> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public HaUtilisateur save(@RequestBody HaUtilisateur user) {
        return repository.save(user);
    }
}