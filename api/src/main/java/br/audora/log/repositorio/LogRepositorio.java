package br.audora.log.repositorio;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.audora.log.dominio.Log;

public interface LogRepositorio extends JpaRepository<Log, Long>, JpaSpecificationExecutor<Log> {

	public List<Log> findAll(Map<String, String> params);
	
}