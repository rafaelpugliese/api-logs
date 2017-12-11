package br.audora.log.domain.enumerations;

import static br.audora.log.util.Constants.Mensagem.VALUE_CLIENT_NOT_FOUND;
import static br.audora.log.util.StringUtils.contains;

import java.util.ArrayList;
import java.util.List;

import br.audora.log.exception.ParametersException;

public enum Client {

	ACRE("Acre"), 
	ALAGOAS("Alagoas"), 
	AMAPA("Amapá"), 
	AMAZONAS("Amazonas"), 
	BAHIA("Bahia"), 
	CEARA("Ceará"), 
	DISTRITO_FEDERAL("Distrito Federal"), 
	ESPIRITO_SANTO("Espírito Santo"), 
	GOIAS("Goiás"), 
	MARANHAO("Maranhão"), 
	MATO_GROSSO("Mato Grosso"), 
	MATO_GROSSO_DO_SUL("Mato Grosso do Sul"), 
	MINAS_GERAIS("Minas Gerais"), 
	PARA("Pará"), 
	PARAIBA("Paraíba"), 
	PARANA("Paraná"), 
	PERNAMBUCO("Pernambuco"), 
	PIAUI("Piauí"), 
	RIO_DE_JANEIRO("Rio de Janeiro"), 
	RIO_GRANDE_DO_NORTE("Rio Grande do Norte"), 
	RIO_GRANDE_DO_SUL("Rio Grande do Sul"), 
	RONDONIA("Rondônia"), 
	RORAIMA("Roraima"), 
	SANTA_CATARINA("Santa Catarina"), 
	SAO_PAULO("São Paulo"), 
	SERGIPE("Sergipe"), 
	TOCANTINS("Tocantins");

	private String description;

	Client(String description) {
		this.description = description;
	}

	public static boolean isValid(String description) {
		List<String> descriptions = new ArrayList<>();

		for (Client client : values()) {
			descriptions.add(client.getDescription());
			if (contains(client.getDescription(), description)) {
				return true;
			}
		}
		throw new ParametersException(VALUE_CLIENT_NOT_FOUND + descriptions.toString());
	}
	
	// TODO
	

	public String getDescription() {
		return description;
	}
	
}