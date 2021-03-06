package br.audora.log.specification;

import static br.audora.log.util.Validator.isNull;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;

import br.audora.log.domain.Log;

public class APILogSpecification {

	public static <T extends Log> Specification<T> like(SingularAttribute<Log, String> key, String value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.<String>get(key)), String.format("%%%s%%", value.toUpperCase()));
			}
		};
	}

	public static <T extends Log> Specification<T> lessThanOrEqualTo(SingularAttribute<Log, Date> key, Date value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.lessThanOrEqualTo(root.<Date>get(key), value);
			}
		};
	}

	public static <T extends Log> Specification<T> greaterThanOrEqualTo(SingularAttribute<Log, Date> key, Date value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.greaterThanOrEqualTo(root.<Date>get(key), value);
			}
		};
	}

	public static Specification<Log> addCondition(Specification<Log> where, Specification<Log> novaClausula) {
		return isNull(where) ? where(novaClausula) : where(where).and(novaClausula);
	}

}