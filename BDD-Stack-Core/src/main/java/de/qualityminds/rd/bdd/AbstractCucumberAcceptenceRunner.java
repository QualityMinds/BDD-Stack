package de.qualityminds.rd.bdd;

import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;

@RunWith(CucumberWithSerenityBDDStackRunner.class)
@CucumberOptions(features = "src/test/resources/features/")
public abstract class AbstractCucumberAcceptenceRunner {
	@Rule
	public SpringIntegrationMethodRule springIntegrationMethodRule = new SpringIntegrationMethodRule();

	public AbstractCucumberAcceptenceRunner() {		
	}
}
