package com.banque.cheques.repository;

import com.banque.cheques.entity.HaRoleUser;
import com.banque.cheques.entity.HaRoleUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaRoleUserRepository extends JpaRepository<HaRoleUser, HaRoleUserId> {
}