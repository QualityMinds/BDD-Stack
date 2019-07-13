package de.qualityminds.rd.bdd;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import de.qualityminds.rd.bdd.spring.SpringConfig;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;

@RunWith(CucumberWithSerenityBDDStackRunner.class)
@CucumberOptions(features = "src/test/resources/features/")
@ContextConfiguration(classes = SpringConfig.class)	
public abstract class AbstractCucumberAcceptenceRunner {
	@Rule
	public SpringIntegrationMethodRule springIntegrationMethodRule = new SpringIntegrationMethodRule();

	public AbstractCucumberAcceptenceRunner() {		
	}
}
