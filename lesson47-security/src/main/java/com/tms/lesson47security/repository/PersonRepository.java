package com.tms.lesson47security.repository;

import com.tms.lesson47security.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByLogin(String username);
}
