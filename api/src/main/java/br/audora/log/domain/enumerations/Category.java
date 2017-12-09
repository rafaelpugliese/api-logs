package br.audora.log.domain.enumerations;

import java.util.ArrayList;
import java.util.List;

import br.audora.log.exception.ParametersException;
import static br.audora.log.util.Constants.Mensagem.*;

public enum Category {

	ERRO("erro"), PERMISSAO("permissão"), AUTENTICACAO("autenticação");

	String description;

	Category(String description) {
		this.description = description;
	}

	public static boolean isValid(String description) {
		List<String> descriptions = new ArrayList<>();

		for (Category category : values()) {
			descriptions.add(category.getDescription());
			if (category.description.toLowerCase().contains(description.toLowerCase())) {
				return true;
			}
		}
		throw new ParametersException(VALUE_CATEGORY_NOT_FOUND + descriptions.toString());
	}

	public String getDescription() {
		return description;
	}

}