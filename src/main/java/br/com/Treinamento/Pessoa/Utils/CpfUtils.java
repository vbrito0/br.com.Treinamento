package br.com.Treinamento.Pessoa.Utils;

public class CpfUtils {

	public static String formatarCpf(String cpf) {
		return cpf.replaceAll("\\D+", "");
	}

	public static String adicionarMascara(String cpf) {
		cpf = cpf.replaceAll("\\D+", "");
		if (cpf.length() == 11) {
			return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
		}
		return cpf;
	}
}
