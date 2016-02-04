package br.com.exame.utils;

public class ValidadorUtils {

	public static boolean isCpfValido(String cpf){
		return cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}") || cpf.matches("[0-9]{11}");
	}
	
	public static boolean isCnpjValido(String cnpj){
		return cnpj.matches("[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}") || cnpj.matches("[0-9]{14}");
	}
}
