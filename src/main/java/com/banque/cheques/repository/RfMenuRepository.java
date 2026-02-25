package com.banque.cheques.repository;

import com.banque.cheques.entity.RfMenu;
import com.banque.cheques.entity.RfMenuId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RfMenuRepository extends JpaRepository<RfMenu, RfMenuId> {
}