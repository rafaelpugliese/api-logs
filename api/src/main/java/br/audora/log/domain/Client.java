package br.audora.log.domain;

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

	String description;

	Client(String description) {
		this.description = description;
	}

	public static boolean isValid(String description) {
		List<String> descriptions = new ArrayList<>();

		for (Client client : values()) {
			descriptions.add(client.getDescription());
			if (client.description.toLowerCase().contains(description.toLowerCase())) {
				return true;
			}
		}
		throw new ParametersException(
				"Valor não encontrado! Possíveis valores para clientes são: " + descriptions.toString());
	}

	public String getDescription() {
		return description;
	}
	
}