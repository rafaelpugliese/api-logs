package br.audora.log.specification;

import static br.audora.log.specification.APILogSpecification.addCondition;
import static br.audora.log.specification.APILogSpecification.greaterThanOrEqualTo;
import static br.audora.log.specification.APILogSpecification.lessThanOrEqualTo;
import static br.audora.log.specification.APILogSpecification.like;
import static br.audora.log.util.Converter.convert;
import static br.audora.log.util.Validator.isCategoryValid;
import static br.audora.log.util.Validator.isClientValid;
import static br.audora.log.util.Validator.isDateValid;
import static br.audora.log.util.Validator.isProductValid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.audora.log.domain.Category;
import br.audora.log.domain.Client;
import br.audora.log.domain.Log;
import br.audora.log.domain.Log_;
import br.audora.log.domain.Product;

public class LogSpecificationBuilder {

	private List<Specification<Log>> conditions = new ArrayList<>();

	public LogSpecificationBuilder byProduct(String product) {
		if (isProductValid(product) && Product.isValid(product)) {
			conditions.add(like(Log_.produto, product));
		}
		return this;
	}

	public LogSpecificationBuilder byClient(String client) {
		if (isClientValid(client) && Client.isValid(client)) {
			conditions.add(like(Log_.cliente, client));
		}
		return this;
	}

	public LogSpecificationBuilder byCategory(String category) {
		if (isCategoryValid(category) && Category.isValid(category)) {
			conditions.add(like(Log_.categoria, category));
		}
		return this;
	}

	public LogSpecificationBuilder byStartDate(String startDate) {
		if (isDateValid(startDate)) {
			conditions.add(greaterThanOrEqualTo(Log_.dataHora, convert(startDate)));
		}
		return this;
	}

	public LogSpecificationBuilder byFinalDate(String finalDate) {
		if (isDateValid(finalDate)) {
			conditions.add(lessThanOrEqualTo(Log_.dataHora, convert(finalDate)));
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