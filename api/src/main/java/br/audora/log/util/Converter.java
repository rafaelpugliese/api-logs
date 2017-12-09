package br.audora.log.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.audora.log.exception.ParametersException;

public class Converter {

	public static final String FORMAT_DATE = "yyyy-MM-dd hh:mm:ss"; 
	
	public static Date convert(String dateToValdate) {
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
		formatter.setLenient(false);
		Date parsedDate = null;
		try {
			parsedDate = formatter.parse(dateToValdate);
		} catch (ParseException e) {
			throw new ParametersException(
					"Data está com o formato inválido, formato esperado: " + FORMAT_DATE);
		}
		return parsedDate;
	}
}