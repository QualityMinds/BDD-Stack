package de.qualityminds.rd.bdd;


import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import de.qualityminds.rd.bdd.Steps;

public class TestStartupSteps extends Steps{
	
	@Autowired
	Test test;
	
	@Given("injection works")
	public void injectionWorks() {
		System.out.println("injection works " + test);
	}
}
