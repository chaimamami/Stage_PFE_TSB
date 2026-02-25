package com.banque.cheques.controller;

import com.banque.cheques.entity.RfMenu;
import com.banque.cheques.repository.RfMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class RfMenuController {

    private final RfMenuRepository repository;

    @GetMapping
    public List<RfMenu> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public RfMenu save(@RequestBody RfMenu menu) {
        return repository.save(menu);
    }
}