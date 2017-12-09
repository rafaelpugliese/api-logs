package br.audora.log.domain.enumerations;

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
		throw new ParametersException(
				"Valor não encontrado! Possíveis valores para produtos são: " + descriptions.toString());
	}

	public String getDescription() {
		return description;
	}

}