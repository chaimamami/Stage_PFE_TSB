package com.banque.cheques.controller;

import com.banque.cheques.dto.HaRoleMenuRequest;
import com.banque.cheques.entity.HaRoleMenu;
import com.banque.cheques.entity.HaRoleMenuId;
import com.banque.cheques.repository.HaRoleMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/role-menus")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class HaRoleMenuController {

    private final HaRoleMenuRepository repository;

    @GetMapping
    public List<HaRoleMenu> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public HaRoleMenu save(@RequestBody HaRoleMenuRequest req) {

        // 1) Nettoyage
        String menu = req.getMenu() == null ? null : req.getMenu().trim();
        String codLan = req.getCodLan() == null ? null : req.getCodLan().trim();
        String role = req.getRole() == null ? null : req.getRole().trim();

        // 2) Validation simple
        if (menu == null || menu.isEmpty() || codLan == null || codLan.isEmpty() || role == null || role.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "menu, codLan, role sont obligatoires");
        }

        // 3) Vérifier que le parent existe dans IBANKT.RF_MENU
        int parentExists = repository.parentExists(menu, codLan);
        if (parentExists == 0) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Menu parent introuvable dans IBANKT.RF_MENU (MENU=" + menu + ", COD_LAN=" + codLan + ")"
            );
        }

        // 4) Construire l'entity correctement (EmbeddedId)
        HaRoleMenu entity = new HaRoleMenu();
        HaRoleMenuId id = new HaRoleMenuId(menu, codLan, role);
        entity.setId(id);

        // 5) Save + message clair si FK casse quand même
        try {
            return repository.save(entity);
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Insertion refusée par Oracle (FK ROL_MEN_MEN_FK). Vérifie IBANKT.RF_MENU pour MENU=" + menu + ", COD_LAN=" + codLan,
                    ex
            );
        }
    }
}