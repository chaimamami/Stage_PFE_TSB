package com.banque.cheques.controller;

import com.banque.cheques.entity.HaRoleUser;
import com.banque.cheques.repository.HaRoleUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-users")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class HaRoleUserController {

    private final HaRoleUserRepository repository;

    @GetMapping
    public List<HaRoleUser> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public HaRoleUser save(@RequestBody HaRoleUser roleUser) {
        return repository.save(roleUser);
    }
}