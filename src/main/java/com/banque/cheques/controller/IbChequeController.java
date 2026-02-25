package com.banque.cheques.controller;

import com.banque.cheques.entity.IbCheque;
import com.banque.cheques.repository.IbChequeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cheques")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class IbChequeController {

    private final IbChequeRepository repository;

    @GetMapping
    public List<IbCheque> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public IbCheque create(@RequestBody IbCheque c) {
        if (c.getNumCpt() != null) c.setNumCpt(c.getNumCpt().trim());
        if (c.getCodSta() != null) c.setCodSta(c.getCodSta().trim());
        if (c.getCleSecurite() != null) c.setCleSecurite(c.getCleSecurite().trim());
        return repository.save(c);
    }
}