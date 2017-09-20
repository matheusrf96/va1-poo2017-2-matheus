package br.unincor.exception;

import br.unincor.model.Pokemon;

public class EvolucaoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Pokemon p;
	
	public EvolucaoException(Pokemon p) {
		super();
		this.p = p;
	}

	@Override
	public String getMessage() {
		return "Erro ao evoluir o pokemon <" + p.getNome() + ">. CP insuficiente.";
	}

}
