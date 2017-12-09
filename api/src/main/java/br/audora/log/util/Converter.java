package br.audora.log.util;

import static br.audora.log.util.Constants.Mensagem.FORMAT_DATE_WRORNG;

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
			throw new ParametersException(FORMAT_DATE_WRORNG + FORMAT_DATE);
		}
		return parsedDate;
	}
}