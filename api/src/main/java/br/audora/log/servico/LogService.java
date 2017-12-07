package br.audora.log.servico;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.audora.log.dominio.Log;
import br.audora.log.repositorio.LogRepositorio;

@Service
public class LogService {

	@Autowired
	private LogRepositorio logRepositorioImpl;

	public List<Log> findAll(Map<String, String> params) {
		return logRepositorioImpl.findAll(params);
	}

}