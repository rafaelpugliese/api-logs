package br.audora.log.dominio;

public enum Categoria {

	ERRO("erro"), PERMISSAO("permissão"), AUTENTICACAO("autenticação");

	String descricao;

	Categoria(String descricao) {
		this.descricao = descricao;
	}

	public static boolean isValid(String categoria) {
		for (Categoria p : values()) {
			if (p.descricao.toLowerCase().contains(categoria.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}