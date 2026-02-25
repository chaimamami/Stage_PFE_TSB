package com.banque.cheques.repository;

import com.banque.cheques.entity.CmPersonne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CmPersonneRepository extends JpaRepository<CmPersonne, String> {
}