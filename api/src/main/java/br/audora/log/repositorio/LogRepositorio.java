package br.audora.log.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.audora.log.dominio.Log;

@Repository
public interface LogRepositorio extends JpaRepository<Log, Long> {

}