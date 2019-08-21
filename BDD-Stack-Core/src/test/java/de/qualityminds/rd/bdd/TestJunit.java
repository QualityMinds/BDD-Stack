package de.qualityminds.rd.bdd;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.qualityminds.rd.bdd.config.TestProperties;
import de.qualityminds.rd.bdd.spring.SpringConfig;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;

@SpringBootTest(classes = SpringConfig.class)	
public class TestJunit {	
	@Autowired
	TestProperties properties;
	
	@Test
	public void testAutowired() {
		assertNotNull(properties);
	}
	
	@Test
	public void propertyRead() {
		assertNotNull(properties.getTestProperty());
		System.out.println("Test Property read from config : " + properties.getTestProperty());
	}
}
