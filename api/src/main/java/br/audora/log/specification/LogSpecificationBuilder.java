package br.audora.log.specification;

import static br.audora.log.specification.APILogSpecification.addCondition;
import static br.audora.log.specification.APILogSpecification.like;
import static br.audora.log.specification.APILogSpecification.greaterThanOrEqualTo;
import static br.audora.log.specification.APILogSpecification.lessThanOrEqualTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.audora.log.domain.Category;
import br.audora.log.domain.Client;
import br.audora.log.domain.Log;
import br.audora.log.domain.Product;
import br.audora.log.util.Validator;

public class LogSpecificationBuilder {

	private List<Specification<Log>> conditions = new ArrayList<>();

	public LogSpecificationBuilder byProduct(String product) {
		if (Validator.isProductValid(product) && Product.isValid(product)) {
			conditions.add(like("produto", product));
		}
		return this;
	}

	public LogSpecificationBuilder byClient(String client) {
		if (Validator.isClientValid(client) && Client.isValid(client)) {
			conditions.add(like("cliente", client));
		}
		return this;
	}

	public LogSpecificationBuilder byCategory(String category) {
		if (Validator.isCategoryValid(category) && Category.isValid(category)) {
			conditions.add(like("categoria", category));
		}
		return this;
	}

	public LogSpecificationBuilder byRegistros(String registros) {
		conditions.add(like("registros", registros));
		return this;
	}

	public LogSpecificationBuilder byDataInicial(String startDate) {
		if (Validator.isDateValid(startDate)) {
			conditions.add(greaterThanOrEqualTo("dataHora", Validator.convert(startDate)));
		}
		return this;
	}

	public LogSpecificationBuilder byDataFinal(String finalDate) {
		if (Validator.isDateValid(finalDate)) {
			conditions.add(lessThanOrEqualTo("dataHora", Validator.convert(finalDate)));
		}
		return this;
	}

	public Specification<Log> build() {
		Specification<Log> where = null;

		for (Specification<Log> condition : conditions) {
			where = addCondition(where, condition);
		}

		return where;
	}

}