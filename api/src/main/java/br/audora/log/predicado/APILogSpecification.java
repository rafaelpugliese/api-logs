package br.audora.log.predicado;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import br.audora.log.dominio.Log;

public class APILogSpecification {

	public static <T extends Log> Specification<T> byLike(String key, String value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.<String>get(key)), String.format("%%%s%%", value.toUpperCase()));
			}
		};
	}

	public static <T extends Log> Specification<T> byMenor(String key, Date value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.lessThanOrEqualTo(root.<Date>get(key), value);
			}
		};
	}

	public static <T extends Log> Specification<T> byMaior(String key, Date value) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.greaterThanOrEqualTo(root.<Date>get(key), value);
			}
		};
	}

	public static Specification<Log> addClausula(Specification<Log> where, Specification<Log> novaClausula) {
		return where == null ? Specifications.where(novaClausula) : Specifications.where(where).and(novaClausula);
	}

}