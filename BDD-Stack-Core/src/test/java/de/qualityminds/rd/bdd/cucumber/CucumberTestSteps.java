package de.qualityminds.rd.bdd.cucumber;


import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Then;
import de.qualityminds.rd.bdd.Steps;
import de.qualityminds.rd.bdd.spring.SpringTestComponent;

public class CucumberTestSteps extends Steps{
	
	@Autowired
	SpringTestComponent test;
	
	@Then("step executes")
	public void stepExecutes() {
		System.out.println("Step works");
	}
	
	@Then("injection works")
	public void injectionWorks() {
		assertNotNull(test);
		System.out.println("Injection works");
	}
}
