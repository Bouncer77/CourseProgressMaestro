package com.bouncer77.CourseProgressMaestro;

import com.bouncer77.CourseProgressMaestro.entity.Author;
import com.bouncer77.CourseProgressMaestro.jdbc.AuthorJdbcDao;
import com.bouncer77.CourseProgressMaestro.repository.AuthorRepository;
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
	AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {

		Author author1 = new Author("Anna", "Andreeva", "Ivanovna");
		Author author2 = new Author( "Olesya", "Andreeva", "Ivanovna");
		Author author3 = new Author( "Nick", "Anisimov", "Alexandrovich");

		List<Author> authorList = Arrays.asList(author1, author2, author3);

		authorRepository.saveAll(authorList);

		System.out.println(authorRepository.findAll());
	}
}
