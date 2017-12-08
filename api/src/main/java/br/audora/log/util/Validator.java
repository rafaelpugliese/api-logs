package br.audora.log.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.audora.log.exception.ParametersException;

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
	
	public static Date convert(String dateToValdate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setLenient(false);
		Date parsedDate = null;
		try {
			parsedDate = formatter.parse(dateToValdate);
		} catch (ParseException e) {
			throw new ParametersException("Data está com o formato inválido, formato esperado: "+ "yyyy-MM-dd");
		}
		return parsedDate;
	}

}