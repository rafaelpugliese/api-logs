package br.audora.log.domain.enumerations;

import static br.audora.log.util.Constants.Mensagem.VALUE_CATEGORY_NOT_FOUND;
import static br.audora.log.util.StringUtils.contains;

import java.util.ArrayList;
import java.util.List;

import br.audora.log.exception.ParametersException;

public enum Category {

	ERRO("Erro"), PERMISSAO("Permissão"), AUTENTICACAO("Autenticação");

	private String description;

	Category(String description) {
		this.description = description;
	}

	public static boolean isValid(String description) {
		List<String> descriptions = new ArrayList<>();

		for (Category category : values()) {
			descriptions.add(category.getDescription());
			if (contains(category.getDescription(), description)) {
				return true;
			}
		}
		throw new ParametersException(VALUE_CATEGORY_NOT_FOUND + descriptions.toString());
	}

	public String getDescription() {
		return description;
	}

}