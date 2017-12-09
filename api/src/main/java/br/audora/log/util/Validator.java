package br.audora.log.util;

import static br.audora.log.util.Converter.convert;

public class Validator {

	public static boolean isProductValid(String value) {
		return value != null;
	}

	public static boolean isCategoryValid(String value) {
		return value != null;
	}

	public static boolean isClientValid(String value) {
		return value != null;
	}

	public static boolean isDateValid(String value) {
		return value != null && validateDateFormat(value);
	}

	public static boolean validateDateFormat(String dateToValdate) {
		return convert(dateToValdate) != null;
	}
}