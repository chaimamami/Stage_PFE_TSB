package com.banque.cheques.repository;

import com.banque.cheques.entity.RfStatut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RfStatutRepository extends JpaRepository<RfStatut, String> {
}