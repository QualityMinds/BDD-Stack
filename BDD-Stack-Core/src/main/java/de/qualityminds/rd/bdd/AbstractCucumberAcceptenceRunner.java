package de.qualityminds.rd.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenityBDDStackRunner.class)
@CucumberOptions(features = "src/test/resources/features/")
public abstract class AbstractCucumberAcceptenceRunner {
	public AbstractCucumberAcceptenceRunner() {		
	}
}
