package de.raeuberbraeu.bms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import de.raeuberbraeu.bms.domain.Hops;

public interface HopsRepository extends JpaRepository<Hops, Long> {
}
