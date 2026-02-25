package com.banque.cheques.repository;

import com.banque.cheques.entity.IbDemandeChequier;
import com.banque.cheques.entity.IbDemandeChequierId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbDemandeChequierRepository extends JpaRepository<IbDemandeChequier, IbDemandeChequierId> {
}