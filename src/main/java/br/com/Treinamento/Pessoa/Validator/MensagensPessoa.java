package br.com.Treinamento.Pessoa.Validator;

public class MensagensPessoa {

	private static final String ID_NULL = "O campo do id está nulo";
	private static final String CAMPO_NOME_VAZIO_OU_NULO = "O campo do nome da pessoa está vázia ou nula";
	private static final String CAMPO_NOME_FANTASIA_VAZIO_OU_NULO = "O campo de nome fantasia está vázio ou nulo";
	private static final String CAMPO_LOGRADOURO_VAZIO_OU_NULO = "O campo do logradouro está vázio ou nulo";
	private static final String CAMPO_BAIRRO_VAZIO_OU_NULO = "O campo de bairro está vázio ou nulo";
	private static final String CAMPO_CIDADE_VAZIO_OU_NULO = "O campo de cidade está vázio ou nulo";
	private static final String CAMPO_CEP_VAZIO_OU_NULO = "O campo de cep está vázio ou nulo";
	private static final String CAMPO_UF_VAZIO_OU_NULO = "O campo de uf está vázio ou nulo";
	private static final String CAMPO_NUMERO_NULO = "O campo do numero está nulo";

	public static String getMensagemCampoId(String campo) {
        return ID_NULL.formatted(campo);
    }

	public static String getMensagemCampoNome(String campo) {
		return CAMPO_NOME_VAZIO_OU_NULO.formatted(campo);
	}

	public static String getMensagemCampoNomeFantasia(String campo) {
		return CAMPO_NOME_FANTASIA_VAZIO_OU_NULO.formatted(campo);
	}

	public static String getMensagemCampoLogradouro(String campo) {
		return CAMPO_LOGRADOURO_VAZIO_OU_NULO.formatted(campo);
	}

	public static String getMensagemCampoBairro(String campo) {
		return CAMPO_BAIRRO_VAZIO_OU_NULO.formatted(campo);
	}

	public static String getMensagemCampoCidade(String campo) {
		return CAMPO_CIDADE_VAZIO_OU_NULO.formatted(campo);
	}

	public static String getMensagemCampoCep(String campo) {
		return CAMPO_CEP_VAZIO_OU_NULO.formatted(campo);
	}

	public static String getMensagemCampoUf(String campo) {
		return CAMPO_UF_VAZIO_OU_NULO.formatted(campo);
	}

	public static String getMensagemCampoNumero(String campo) {
		return CAMPO_NUMERO_NULO.formatted(campo);
	}

}
