package br.com.Treinamento.Pessoa.Utils;

/*
 * Classe responsavel por formatar, remover os caracteres e veridicar se o cnpj é válido
 */
public class CnpjUtils {

	public static String formatarCnpj(String cnpj) {
		String cnpjLimpo = limparCnpj(cnpj);
		return cnpjLimpo.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
	}

	public static String limparCnpj(String cnpj) {
		return cnpj.replaceAll("\\D", "");
	}

	public static boolean validarCnpj(String cnpj) {
		String cnpjLimpo = limparCnpj(cnpj);

		if (cnpjLimpo.length() != 14 || cnpjLimpo.matches("(\\d)\\1{13}")) {
			return false;
		}

		return calcularDigitoVerificador(cnpjLimpo).equals(cnpjLimpo.substring(12));
	}

	private static String calcularDigitoVerificador(String cnpj) {
		int[] pesosPrimeiroDigito = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		int[] pesosSegundoDigito = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

		int primeiroDigito = calcularDigito(cnpj.substring(0, 12), pesosPrimeiroDigito);
		int segundoDigito = calcularDigito(cnpj.substring(0, 12) + primeiroDigito, pesosSegundoDigito);

		return "" + primeiroDigito + segundoDigito;
	}

	private static int calcularDigito(String str, int[] pesos) {
		int soma = 0;
		for (int i = 0; i < pesos.length; i++) {
			soma += Character.getNumericValue(str.charAt(i)) * pesos[i];
		}
		int resto = soma % 11;
		return (resto < 2) ? 0 : 11 - resto;
	}
}
