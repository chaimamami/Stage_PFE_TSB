package com.banque.cheques.repository;

import com.banque.cheques.entity.IbCheque;
import com.banque.cheques.entity.IbChequeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbChequeRepository extends JpaRepository<IbCheque, IbChequeId> {
}