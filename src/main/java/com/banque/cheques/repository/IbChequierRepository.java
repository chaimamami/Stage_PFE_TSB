package com.banque.cheques.repository;

import com.banque.cheques.entity.IbChequier;
import com.banque.cheques.entity.IbChequierId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbChequierRepository extends JpaRepository<IbChequier, IbChequierId> {
}