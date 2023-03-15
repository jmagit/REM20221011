package com.example.domains.contracts.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.domains.entities.Category;

@DataJpaTest
class CategoriaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CategoriaRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		entityManager.persist(new Category(1, "Comedia"));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		var rs = repository.findAll();
		assertEquals(rs.size(), 1);
	}

}
