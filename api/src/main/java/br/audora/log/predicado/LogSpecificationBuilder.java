package br.audora.log.predicado;

import static br.audora.log.predicado.APILogSpecification.addClausula;
import static br.audora.log.predicado.APILogSpecification.byLike;
import static br.audora.log.predicado.APILogSpecification.byMaior;
import static br.audora.log.predicado.APILogSpecification.byMenor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.audora.log.dominio.Categoria;
import br.audora.log.dominio.Cliente;
import br.audora.log.dominio.Log;
import br.audora.log.dominio.Produto;
import br.audora.log.util.Validator;

public class LogSpecificationBuilder {

	private List<Specification<Log>> clausulas = new ArrayList<>();

	public LogSpecificationBuilder byProduto(String produto) {
		if (Validator.isProdutoValido(produto) && Produto.isValid(produto)) {
			clausulas.add(byLike("produto", produto));
		}
		return this;
	}

	public LogSpecificationBuilder byCliente(String cliente) {
		if (Validator.isClienteValido(cliente) && Cliente.isValid(cliente)) {
			clausulas.add(byLike("cliente", cliente));
		}
		return this;
	}

	public LogSpecificationBuilder byCategoria(String categoria) {
		if (Validator.isCategoriaValida(categoria) && Categoria.isValid(categoria)) {
			clausulas.add(byLike("categoria", categoria));
		}
		return this;
	}

	public LogSpecificationBuilder byRegistros(String registros) {
		clausulas.add(byLike("registros", registros));
		return this;
	}

	public LogSpecificationBuilder byDataInicial(String dataInicial) {
		if (Validator.isDataValida(dataInicial)) {
			clausulas.add(byMaior("dataHora", Validator.convert(dataInicial)));
		}
		return this;
	}

	public LogSpecificationBuilder byDataFinal(String dataFinal) {
		if (Validator.isDataValida(dataFinal)) {
			clausulas.add(byMenor("dataHora", Validator.convert(dataFinal)));
		}
		return this;
	}

	public Specification<Log> build() {
		Specification<Log> where = null;

		for (Specification<Log> s : clausulas) {
			where = addClausula(where, s);
		}

		return where;
	}

}