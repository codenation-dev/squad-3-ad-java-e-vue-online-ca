package dev.codenation.squad03.central.de.erros.usuario.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Classe responsável por manipular (encriptar e validar) a senha de um usuário.
 * 
 * @since 22.08.2019
 * @version 1.0
 *
 */
public class UtilService {

	/**
	 * Método responsável por gerar um hash utilizando BCrypt
	 * 
	 * @param senha
	 * @return { @link String }
	 */
	public static String gerarBCrypt(String password) {
		if (password == null) {
			return password;
		} else {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			return bCryptPasswordEncoder.encode(password);
		}
	}

	/**
	 * Método responsável por verificar se a senha é válida
	 * 
	 * @param password
	 * @param encodedPassword
	 * @return boolean
	 */
	public static boolean isSenhaValida(String password, String encodedPassword) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.matches(password, encodedPassword);
	}
}
