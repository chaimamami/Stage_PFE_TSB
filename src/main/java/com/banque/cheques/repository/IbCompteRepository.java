package com.banque.cheques.repository;

import com.banque.cheques.entity.IbCompte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbCompteRepository extends JpaRepository<IbCompte, String> {
}