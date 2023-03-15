package com.example.application.resources;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

class CotillaResourceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetBalanceoRT() {
		WebTestClient client = WebTestClient.bindToController(new CotillaResource()).build();
	}

	@Test
	void testGetPelisRT() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPelisRTInt() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBalanceoProxy() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPelisProxy() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPelisProxyInt() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPelisLike() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCircuitBreakerFactory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCircuitBreakerAnota() {
		fail("Not yet implemented");
	}

	@Test
	void testGetConfig() {
		fail("Not yet implemented");
	}

}
