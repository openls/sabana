package org.sabana;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.sabana.core.entity.ApplicationVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SabanaApplicationTests {

	@Autowired
	private TestRestTemplate tester;

	@Test
	void version() {
		ResponseEntity<ApplicationVersion> versionEntity = this.tester.getForEntity("/version", ApplicationVersion.class);
		ApplicationVersion version = versionEntity.getBody();
		assertNotNull(version);
		assertTrue(version.getName().contains("Sabana"));
	}

}
