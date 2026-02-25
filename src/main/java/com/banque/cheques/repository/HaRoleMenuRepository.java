package com.banque.cheques.repository;

import com.banque.cheques.entity.HaRoleMenu;
import com.banque.cheques.entity.HaRoleMenuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HaRoleMenuRepository extends JpaRepository<HaRoleMenu, HaRoleMenuId> {

    @Query(value = "SELECT COUNT(1) FROM IBANKT.RF_MENU WHERE MENU = :menu AND COD_LAN = :codLan", nativeQuery = true)
    int parentExists(@Param("menu") String menu, @Param("codLan") String codLan);
}