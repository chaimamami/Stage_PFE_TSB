package com.banque.cheques.controller;

import com.banque.cheques.entity.IbChequier;
import com.banque.cheques.repository.IbChequierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/chequiers")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class IbChequierController {

    private final IbChequierRepository repository;

    @GetMapping
    public List<IbChequier> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public IbChequier create(@RequestBody IbChequier c) {
        if (c.getNumCpt() != null) c.setNumCpt(c.getNumCpt().trim());
        if (c.getCodUg() != null) c.setCodUg(c.getCodUg().trim());
        if (c.getCodSta() != null) c.setCodSta(c.getCodSta().trim());
        if (c.getUseCre() != null) c.setUseCre(c.getUseCre().trim());

        if (c.getDatCre() == null) c.setDatCre(new Date());

        return repository.save(c);
    }
}