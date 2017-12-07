package br.audora.log.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.audora.log.dominio.Log;
import br.audora.log.repositorio.LogRepositorio;

@Service
public class LogService {

	@Autowired
	private LogRepositorio logRepository;

	public Log findById(Long id) {
		return logRepository.findOne(id);
	}

}