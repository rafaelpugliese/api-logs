package br.audora.log.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.audora.log.exception.ParametersException;

public class ValidatorTest {

	@Test
	public void testProductIsValid() {
		assertTrue(Validator.isProductValid("Product"));
	}

	@Test
	public void testProductIsNotValid() {
		assertFalse(Validator.isProductValid(null));
	}

	@Test
	public void testCategoryIsValid() {
		assertTrue(Validator.isCategoryValid("Category"));
	}

	@Test
	public void testCategoryIsNotValid() {
		assertFalse(Validator.isCategoryValid(null));
	}

	@Test
	public void testClientIsValid() {
		assertTrue(Validator.isClientValid("Client"));
	}

	@Test
	public void testClientIsNotValid() {
		assertFalse(Validator.isClientValid(null));
	}

	@Test
	public void testDateIsValid() {
		assertTrue(Validator.isDateValid("2017-12-16 08:40:10"));
	}

	@Test(expected = ParametersException.class)
	public void testDateIsNotValidFormat() {
		Validator.isDateValid("16/12/2017");
	}

	@Test
	public void testDateIsNotValid() {
		assertFalse(Validator.isDateValid(null));
	}

}