package de.qualityminds.rd.bdd.cucumber;


import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Then;
import de.qualityminds.rd.bdd.Steps;
import de.qualityminds.rd.bdd.config.TestProperties;

public class CucumberTestSteps extends Steps{
	@Autowired 
	TestProperties properties;
	
	@Then("step executes")
	public void stepExecutes() {
		System.out.println("Step works");
	}
	
	@Then("injection works")
	public void injectionWorks() {
		assertNotNull(properties);
		System.out.println("Injection works");
	}
	
	@Then("test property is correctly read")
	public void testPropertyIsCorrectlyRead() {
		assertNotNull(properties.getTestProperty());
		System.out.println("Test Property from config : " + properties.getTestProperty());
	}
}
