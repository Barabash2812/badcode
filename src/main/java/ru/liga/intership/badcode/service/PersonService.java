package ru.liga.intership.badcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.intership.badcode.domain.Person;
import ru.liga.intership.badcode.exception.PersonNotFoundException;
import ru.liga.intership.badcode.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Double getPeopleOlderThenAgeAndSex(Long age, String sex) throws PersonNotFoundException {
        double totalImt;
        List<Person> adultPersons;

        adultPersons = personRepository.findPeopleByAgeAfterAndSex(age, sex).orElseThrow(
                () -> new PersonNotFoundException("People older then " + age + " age with sex " + sex + " not found")
        );

        totalImt = adultPersons.stream()
                .map(person -> {
                    double heightInMeters = person.getHeight() / 100d;
                    return person.getWeight() / (Double) (heightInMeters * heightInMeters);
                })
                .mapToDouble(imt -> imt)
                .sum();

        double averageBMI = totalImt / adultPersons.size();
        System.out.println("Average imt - " + averageBMI);

        return averageBMI;
    }
}
