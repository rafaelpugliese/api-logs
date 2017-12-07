package br.audora.log.repositorio;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import br.audora.log.dominio.Log;
import br.audora.log.predicado.LogSpecificationBuilder;

@Repository
public class LogRepositorioImpl extends SimpleJpaRepository<Log, Long> implements LogRepositorio {

	public LogRepositorioImpl(EntityManager em) {
		super(Log.class, em);
	}

	@Override
	public List<Log> findAll(Map<String, String> params) {
		LogSpecificationBuilder builder = new LogSpecificationBuilder();

		Specification<Log> where = builder.byCategoria(params.get("categoria"))
				.byProduto(params.get("produto"))
				.byCliente(params.get("cliente"))
				.byDataInicial(params.get("dataInicial"))
				.byDataFinal(params.get("dataFinal"))
				.build();

		return findAll(where);
	}

}