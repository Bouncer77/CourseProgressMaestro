package com.bouncer77.CourseProgressMaestro;

import com.bouncer77.CourseProgressMaestro.entity.Address;
import com.bouncer77.CourseProgressMaestro.entity.Passport;
import com.bouncer77.CourseProgressMaestro.entity.Person;
import com.bouncer77.CourseProgressMaestro.entity.Phone;
import com.bouncer77.CourseProgressMaestro.repository.PassportRepository;
import com.bouncer77.CourseProgressMaestro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CourseProgressMaestroApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(CourseProgressMaestroApplication.class, args);

	}

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PassportRepository passportRepository;

	@Override
	public void run(String... args) {

		// Person
		Person anna = new Person("Anna", "Andreeva");
		Person olesya = new Person("Olesya", "Andreeva");

		// passport
		Passport passportAnna = new Passport("111111111");
		Passport passportOlesya = new Passport("222222222");

		// phones
		Phone annaPhone1 = new Phone("89001112233");
		Phone annaPhone2 = new Phone("89001112244");
		Phone olesyaPhone1 = new Phone("89001112255");

		// addresses
		Address address1 = new Address("Samara");
		Address address2 = new Address("Omsk");
		Address address3 = new Address("Novosibirsk");
		Address address4 = new Address("Moscow");


		anna.setPassport(passportAnna);
		anna.setPhoneList(Arrays.asList(annaPhone1, annaPhone2));
		anna.setAddress(Arrays.asList(address1, address2));


		olesya.setPassport(passportOlesya);
		olesya.setPhoneList(Arrays.asList(olesyaPhone1));
		olesya.setAddress(Arrays.asList(address3, address4));

		List<Person> people = Arrays.asList(anna, olesya);
		// Casscade.ALL => когда сохраняем people сохраняются и паспорта
		personRepository.saveAll(people);
		System.out.println("<<<<<<<<<" + personRepository.findAll());
	}
}
