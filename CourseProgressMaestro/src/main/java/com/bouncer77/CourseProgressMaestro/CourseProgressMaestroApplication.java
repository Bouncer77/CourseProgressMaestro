package com.bouncer77.CourseProgressMaestro;

import com.bouncer77.CourseProgressMaestro.entity.Person;
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

	/*@Autowired
	AuthorRepository authorRepository;*/

	@Autowired
	PersonRepository personRepository;

	/*@Autowired
	PassportRepository passportRepository;*/

	@Override
	public void run(String... args) {

		// Author
		/*Author author1 = new Author("Anna", "Andreeva", "Ivanovna");
		Author author2 = new Author( "Olesya", "Andreeva", "Ivanovna");
		Author author3 = new Author( "Nick", "Anisimov", "Alexandrovich");
		List<Author> authorList = Arrays.asList(author1, author2, author3);
		authorRepository.saveAll(authorList);*/


		// Person
		Person anna = new Person("Anna", "Andreeva", "Samara");
		Person olesya = new Person("Olesya", "Andreeva", "Moscow");

		/*Passport passportAnna = new Passport("111111111");
		Passport passportOlesya = new Passport("222222222");

		anna.setPassport(passportAnna);
		olesya.setPassport(passportOlesya);*/

		List<Person> people = Arrays.asList(anna, olesya);
		// Casscade.ALL => когда сохраняем people сохраняются и паспорта
		personRepository.saveAll(people);
		System.out.println("<<<<<<<<<" + personRepository.findAll());

		System.out.println(personRepository.findAll());
	}
}
