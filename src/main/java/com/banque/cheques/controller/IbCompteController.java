package com.banque.cheques.controller;

import com.banque.cheques.entity.IbCompte;
import com.banque.cheques.repository.IbCompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/comptes")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class IbCompteController {

    private final IbCompteRepository repository;

    @GetMapping
    public List<IbCompte> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public IbCompte create(@RequestBody IbCompte c) {

        if (c.getNumCpt() != null) c.setNumCpt(c.getNumCpt().trim());
        if (c.getCodDev() != null) c.setCodDev(c.getCodDev().trim());
        if (c.getCodUg() != null) c.setCodUg(c.getCodUg().trim());
        if (c.getCodCatCpt() != null) c.setCodCatCpt(c.getCodCatCpt().trim());
        if (c.getCodPro() != null) c.setCodPro(c.getCodPro().trim());
        if (c.getCodSta() != null) c.setCodSta(c.getCodSta().trim());
        if (c.getTypCpt() != null) c.setTypCpt(c.getTypCpt().trim());

        if (c.getDatCre() == null) c.setDatCre(new Date());
        if (c.getDatOuvCpt() == null) c.setDatOuvCpt(new Date());
        if (c.getSldCou() == null) c.setSldCou(0.0);

        if (c.getNumCpt() == null || c.getNumCpt().length() != 13)
            throw new IllegalArgumentException("NUM_CPT doit contenir exactement 13 caractères.");

        if (c.getTypCpt() == null || !"CISR".contains(c.getTypCpt()))
            throw new IllegalArgumentException("TYP_CPT doit être C, I, S ou R.");

        return repository.save(c);
    }
}