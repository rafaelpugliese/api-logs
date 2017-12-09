package br.audora.log.domain.enumerations;

import static br.audora.log.util.Constants.Mensagem.VALUE_PRODUCT_NOT_FOUND;

import java.util.ArrayList;
import java.util.List;

import br.audora.log.exception.ParametersException;

public enum Product {

	DEFENSORIA("DEFENSORIA"), OAB("OAB");

	String description;

	Product(String description) {
		this.description = description;
	}

	public static boolean isValid(String description) {
		List<String> descriptions = new ArrayList<>();

		for (Product product : values()) {
			descriptions.add(product.getDescription());
			if (product.description.toLowerCase().contains(description.toLowerCase())) {
				return true;
			}
		}
		throw new ParametersException(VALUE_PRODUCT_NOT_FOUND + descriptions.toString());
	}

	public String getDescription() {
		return description;
	}

}