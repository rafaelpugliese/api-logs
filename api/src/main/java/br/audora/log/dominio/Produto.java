package br.audora.log.dominio;

public enum Produto {

	Defensoria("DEFENSORIA"), OAB("OAB");

	String descricao;

	Produto(String descricao) {
		this.descricao = descricao;
	}

	public static boolean isValid(String produto) {
		for (Produto p : values()) {
			if (p.descricao.toLowerCase().contains(produto.toLowerCase())) {
				return true;
			}
		}
		throw new RuntimeException("Valor não encontrado!");
	}

}