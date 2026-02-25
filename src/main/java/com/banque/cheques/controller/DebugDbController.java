package com.banque.cheques.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/debug-db")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DebugDbController {

    @PersistenceContext
    private EntityManager em;

    @GetMapping("/check-parent")
    public Map<String, Object> checkParent(@RequestParam String menu,
                                          @RequestParam String codLan) {

        Map<String, Object> res = new HashMap<>();

        // Qui suis-je ?
        String user = (String) em.createNativeQuery("select user from dual").getSingleResult();
        String schema = (String) em.createNativeQuery("select sys_context('USERENV','CURRENT_SCHEMA') from dual")
                .getSingleResult();

        res.put("DB_USER", user);
        res.put("CURRENT_SCHEMA", schema);

        // Vérifier si le parent existe dans IBANKT.RF_MENU
        Number cnt = (Number) em.createNativeQuery(
                        "select count(*) from IBANKT.RF_MENU where MENU = :menu and COD_LAN = :codLan")
                .setParameter("menu", menu)
                .setParameter("codLan", codLan)
                .getSingleResult();

        res.put("PARENT_EXISTS_IN_IBANKT_RF_MENU", cnt.intValue());

        return res;
    }
}