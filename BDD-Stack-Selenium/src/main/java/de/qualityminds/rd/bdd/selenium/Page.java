package de.qualityminds.rd.bdd.selenium;

import java.io.IOError;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.WebDriverRunner;
import com.galenframework.browser.SeleniumBrowser;
import com.galenframework.speclang2.pagespec.PageSpecReader;
import com.galenframework.speclang2.pagespec.SectionFilter;
import com.galenframework.specs.page.PageSpec;
import com.galenframework.validation.CombinedValidationListener;
import com.galenframework.validation.PageValidation;
import com.galenframework.validation.SectionValidation;
import com.galenframework.validation.ValidationResult;

import de.qualityminds.rd.bdd.selenium.annotations.Spec;
import de.qualityminds.rd.bdd.selenium.exceptions.WrongPageValidationError;

public class Page extends net.serenitybdd.core.pages.PageObject {

	public Page(WebDriver driver) {
		super(driver);
		WebDriverRunner.setWebDriver(driver);
	}
	
	@Override
	public void shouldBeDisplayed() {
		List<ValidationResult> validationList = validatePage(true);
		if(!validationList.isEmpty()) {
			throw new WrongPageValidationError(validationList.toString());
		}

		super.shouldBeDisplayed();
	}
	
	public List<ValidationResult> validatePage(boolean fast){
		Spec specAnnotation = this.getClass().getAnnotation(Spec.class);
		if(specAnnotation==null) {
			return new LinkedList<>();
		}
		
		try {
			return galenCheck((fast && !specAnnotation.fast().isEmpty()) ? specAnnotation.fast() : specAnnotation.value());
		} catch (IOException e) {
			throw new IOError(e);
		}
	}
	
	private List<ValidationResult> galenCheck(String specPath) throws IOException {
		SectionFilter sectionFilter = new SectionFilter(new LinkedList<>(), Collections.<String>emptyList());
		Properties properties = new Properties();
				
		SeleniumBrowser browser = new SeleniumBrowser(getDriver());
        PageSpecReader reader = new PageSpecReader();
        
        PageSpec pageSpec = reader.read(specPath, browser.getPage(), sectionFilter, properties, null, null);

        CombinedValidationListener listener = new CombinedValidationListener();

        PageValidation pageValidation = new PageValidation(browser, browser.getPage(), pageSpec, listener, sectionFilter);
		List<ValidationResult> check = new SectionValidation(pageSpec.getSections(), pageValidation, listener).check();
		return check;
	}


}
