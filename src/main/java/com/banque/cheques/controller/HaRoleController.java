package com.banque.cheques.controller;

import com.banque.cheques.entity.HaRole;
import com.banque.cheques.repository.HaRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class HaRoleController {

    private final HaRoleRepository repository;

    @GetMapping
    public List<HaRole> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public HaRole save(@RequestBody HaRole role) {
        return repository.save(role);
    }
}