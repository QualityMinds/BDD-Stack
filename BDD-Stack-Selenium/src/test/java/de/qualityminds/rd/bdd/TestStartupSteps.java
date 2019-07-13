package de.qualityminds.rd.bdd;


import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

public class TestStartupSteps extends Steps{
	
	@Autowired
	Test test;
	
    @ManagedPages(defaultUrl = "http://www.google.com")
    public Pages pages;

	@Given("injection works")
	public void injectionWorks() {
		System.out.println("injection works222 " + test);
		System.out.println(System.getProperty("webdriver.chrome.driver"));

		pages.getDriver().get("http://www.google.com");
		System.out.println("injection works222 " + test);
		
	}
}
