package com.bouncer77.CourseProgressMaestro;

import com.bouncer77.CourseProgressMaestro.entity.Author;
import com.bouncer77.CourseProgressMaestro.jdbc.AuthorJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseProgressMaestroApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(CourseProgressMaestroApplication.class, args);

	}

	@Autowired
	AuthorJdbcDao authorJdbcDao;

	@Override
	public void run(String... args) throws Exception {

		Author author1 = new Author(100, "Anna", "Andreeva", "Ivanovna");
		Author author2 = new Author(200, "Olesya", "Andreeva", "Ivanovna");
		Author author3 = new Author(300, "Nick", "Anisimov", "Alexandrovich");

		authorJdbcDao.insert(author1);
		authorJdbcDao.insert(author2);
		authorJdbcDao.insert(author3);

		System.out.println("<<<<<<<<<<<<<<<<<" + authorJdbcDao.findAll());

	}
}
