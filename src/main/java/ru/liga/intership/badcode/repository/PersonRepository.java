package ru.liga.intership.badcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.intership.badcode.domain.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<List<Person>> findPeopleByAgeAfterAndSex(Long age, String sex);
}
