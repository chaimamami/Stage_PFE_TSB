package com.banque.cheques.controller;

import com.banque.cheques.entity.IbDemandeChequier;
import com.banque.cheques.repository.IbDemandeChequierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/demande-chequier")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class IbDemandeChequierController {

    private final IbDemandeChequierRepository repository;

    @GetMapping
    public List<IbDemandeChequier> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public IbDemandeChequier create(@RequestBody IbDemandeChequier d) {
        if (d.getDatCre() == null) d.setDatCre(new Date());
        if (d.getDatJou() == null) d.setDatJou(new Date());
        if (d.getNbrChe() == null) d.setNbrChe(1);

        if (d.getCodUg() != null) d.setCodUg(d.getCodUg().trim());
        if (d.getCodOpe() != null) d.setCodOpe(d.getCodOpe().trim());
        if (d.getCodTypChq() != null) d.setCodTypChq(d.getCodTypChq().trim());
        if (d.getNumCpt() != null) d.setNumCpt(d.getNumCpt().trim());

        return repository.save(d);
    }
}