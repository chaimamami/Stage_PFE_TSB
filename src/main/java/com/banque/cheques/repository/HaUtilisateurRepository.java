package com.banque.cheques.repository;

import com.banque.cheques.entity.HaUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaUtilisateurRepository extends JpaRepository<HaUtilisateur, String> {
}