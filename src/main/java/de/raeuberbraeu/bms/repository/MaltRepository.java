package de.raeuberbraeu.bms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import de.raeuberbraeu.bms.domain.Malt;

public interface MaltRepository extends JpaRepository<Malt, Long> {

}
