package de.raeuberbraeu.bms.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.raeuberbraeu.bms.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(@Param("lastname") String lastname);

    List<User> findByFirstName(@Param("firstname") String firstname);

}
