package br.audora.log.util;

import static br.audora.log.util.Converter.convert;

public class Validator {

	private static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean isProductValid(String value) {
		return !isNull(value);
	}

	public static boolean isCategoryValid(String value) {
		return !isNull(value);
	}

	public static boolean isClientValid(String value) {
		return !isNull(value);
	}

	public static boolean isDateValid(String value) {
		return !isNull(value) && !isNull(convert(value));
	}

}