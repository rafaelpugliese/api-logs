package br.audora.log.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import br.audora.log.domain.Log;
import br.audora.log.specification.LogSpecificationBuilder;

@Repository
public class LogRepositoryImpl extends SimpleJpaRepository<Log, Long> implements LogRepository {

	public LogRepositoryImpl(EntityManager em) {
		super(Log.class, em);
	}

	@Override
	public List<Log> findAll(Map<String, String> params) {
		LogSpecificationBuilder builder = new LogSpecificationBuilder();

		Specification<Log> where = builder.byCategory(params.get("categoria"))
				.byProduct(params.get("produto"))
				.byClient(params.get("cliente"))
				.byStartDate(params.get("dataInicial"))
				.byFinalDate(params.get("dataFinal"))
				.build();

		return findAll(where);
	}

}