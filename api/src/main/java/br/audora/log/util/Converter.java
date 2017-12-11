package br.audora.log.util;

import static br.audora.log.util.Constants.Mensagem.WRONG_DATE_FORMAT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.audora.log.exception.ParametersException;

public class Converter {

	public static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

	public static Date convert(String dateToValdate) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		formatter.setLenient(false);
		Date parsedDate = null;
		try {
			parsedDate = formatter.parse(dateToValdate);
		} catch (ParseException e) {
			throw new ParametersException(WRONG_DATE_FORMAT + DATE_FORMAT);
		}
		return parsedDate;
	}
}