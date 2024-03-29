package de.qualityminds.rd.bdd;

import java.io.IOException;
import java.util.Map;

import org.junit.runners.model.InitializationError;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import de.qualityminds.rd.bdd.spring.RunnerInit;
import de.qualityminds.rd.bdd.spring.SpringConfig;
import net.serenitybdd.cucumber.CucumberWithSerenity;

public class CucumberWithSerenityBDDStackRunner 
extends CucumberWithSerenity {
		
	public CucumberWithSerenityBDDStackRunner(Class<?> clazz) throws InitializationError, IOException {
		super(clazz);
		initRunners();
	}

	protected void initRunners() {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Map<String, RunnerInit> runners = context.getBeansOfType(RunnerInit.class);
		runners.values().forEach(r -> r.init());
	}
	
}
