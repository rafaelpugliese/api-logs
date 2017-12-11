package br.audora.log.util;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class StringUtils {

	public static boolean contains(String value1, String value2) {
		return removeDiacriticalMarks(value1).toLowerCase().contains(removeDiacriticalMarks(value2).toLowerCase());
	}
	
	public static String removeDiacriticalMarks(String string) {
	    return Normalizer.normalize(string, Form.NFD)
	        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
	
}