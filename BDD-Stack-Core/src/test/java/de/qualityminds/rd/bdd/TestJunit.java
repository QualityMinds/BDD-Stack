package de.qualityminds.rd.bdd;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import de.qualityminds.rd.bdd.spring.SpringConfig;
import de.qualityminds.rd.bdd.spring.SpringTestComponent;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;

@ContextConfiguration(classes = SpringConfig.class)	
public class TestJunit {
	@Rule
	public SpringIntegrationMethodRule springIntegrationMethodRule = new SpringIntegrationMethodRule();

	@Autowired
	SpringTestComponent testComponent;
	
	@Test
	public void testAutowired() {
		assertNotNull(testComponent);
	}
}
