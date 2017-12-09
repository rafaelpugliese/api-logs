package br.audora.log.domain;

import static br.audora.log.util.Converter.FORMAT_DATE;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.audora.log.converter.RegistroConverter;

@Entity
@Table(name = "log")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String produto;

	@Column
	private String cliente;

	// time zone deve ser o mesmo do banco de dados.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FORMAT_DATE, timezone = "America/Maceio")
	@Column
	private Date dataHora;

	@Column
	private String categoria;

	@Column
	@Convert(converter = RegistroConverter.class)
	private Map<String, Object> registros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Map<String, Object> getRegistros() {
		return registros;
	}

	public void setRegistros(Map<String, Object> registros) {
		this.registros = registros;
	}

}
