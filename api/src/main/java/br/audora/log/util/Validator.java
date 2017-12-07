package br.audora.log.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {

	public static boolean isProdutoValido(String value) {
		return value != null;
	}

	public static boolean isCategoriaValida(String value) {
		return value != null;
	}

	public static boolean isClienteValido(String value) {
		return value != null;
	}

	public static boolean isDataValida(String value) {
		return value != null && validateDateFormat(value);
	}

	public static boolean validateDateFormat(String dateToValdate) {

		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// To make strict date format validation
		formatter.setLenient(false);
		Date parsedDate = null;
		try {
			parsedDate = formatter.parse(dateToValdate);
			System.out.println("++validated DATE TIME ++" + formatter.format(parsedDate));

		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static Date convert(String dateToValdate) {

		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// To make strict date format validation
		formatter.setLenient(false);
		Date parsedDate = null;
		try {
			parsedDate = formatter.parse(dateToValdate);
			System.out.println("++validated DATE TIME ++" + formatter.format(parsedDate));

		} catch (ParseException e) {
			return null;
		}
		return parsedDate;
	}

}