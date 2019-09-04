package dev.codenation.squad03.central.de.erros.usuario.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe responsável por encapsular o retorno de todas as requisições da API
 * Central de Erros.
 * 
 * @since 22.08.2019
 * @version 1.0
 * @param <T>
 */
@NoArgsConstructor
public class Response<T> {

	@Setter
	@Getter
	private T data;
	@Setter
	private List<String> erros;

	public List<String> getErros() {
		if (this.erros == null) {
			this.erros = new ArrayList<String>();
		}
		return erros;
	}
}
