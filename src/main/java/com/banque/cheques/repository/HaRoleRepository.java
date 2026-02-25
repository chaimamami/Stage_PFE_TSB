package com.banque.cheques.repository;

import com.banque.cheques.entity.HaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaRoleRepository extends JpaRepository<HaRole, String> {
}