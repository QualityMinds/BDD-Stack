package de.qualityminds.rd.bdd.selenium.exceptions;

public class WrongPageValidationError extends AssertionError{

	private static final long serialVersionUID = 1L;

	public WrongPageValidationError(String msg) {
		super(msg);
		
	}
}
