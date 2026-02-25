package com.banque.cheques.controller;

import com.banque.cheques.entity.RfUg;
import com.banque.cheques.repository.RfUgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rf-ug")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class RfUgController {

    private final RfUgRepository repository;

    @GetMapping
    public List<RfUg> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{codUg}")
    public RfUg getOne(@PathVariable String codUg) {
        return repository.findById(codUg).orElse(null);
    }

    @PostMapping
    public RfUg create(@RequestBody RfUg ug) {
        if (ug.getCodUg() != null) ug.setCodUg(ug.getCodUg().trim());
        if (ug.getLibUg() != null) ug.setLibUg(ug.getLibUg().trim());
        return repository.save(ug);
    }
}