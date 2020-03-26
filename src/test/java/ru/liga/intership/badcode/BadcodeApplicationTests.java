package ru.liga.intership.badcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.liga.intership.badcode.exception.PersonNotFoundException;
import ru.liga.intership.badcode.service.PersonService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BadcodeApplicationTests {

	@Autowired
	PersonService personService;

	@Test
	public void rightAdultMalePeopleAverageBMI() throws PersonNotFoundException {
		assertEquals(personService.getPeopleOlderThenAgeAndSex(18L, "male"), 25.774209960992707, 25.774209960992707 * 0.03);
	}

	@Test
	public void rightYoungFemalePeopleAverageBMI() throws PersonNotFoundException {
		assertEquals(personService.getPeopleOlderThenAgeAndSex(18L, "female"), 19.113573407202217, 19.113573407202217 * 0.03);
	}

	@Test(expected = PersonNotFoundException.class)
	public void rightException() throws PersonNotFoundException {
		personService.getPeopleOlderThenAgeAndSex(70L,"female");
	}
}
