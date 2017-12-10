package br.audora.log.util;

public interface Constants {

	String TIME_ZONE_AMERICA_MACEIO = "America/Maceio";
	String TIME_ZONE_AMERICA_SAO_PAULO = "America/Sao_Paulo";
	
	String TIME_ZONE = TIME_ZONE_AMERICA_MACEIO;

	public interface Mensagem {
		
		String VALUE_CATEGORY_NOT_FOUND = "Possíveis valores para categoria: ";
		String VALUE_PRODUCT_NOT_FOUND = "Possíveis valores para produto: ";
		String VALUE_CLIENT_NOT_FOUND = "Possíveis valores para cliente: ";
		
		String WRONG_DATE_FORMAT = "Data está com o formato inválido, formato esperado: ";
	}

}