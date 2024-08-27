package br.com.Treinamento.Pessoa.Validator.PJ;

public class MensagensPessoaJuridica {

	public static final String PREENCHIMENTO_OBRIGATORIO = "O campo %s é de preenchimento obrigatório";
	public static final String CNPJ_NULO = "O campo do cnpj não pode ser nulo";

	public static String getMensagemCampoObrigatorio(String campo) {
        return String.format(PREENCHIMENTO_OBRIGATORIO, campo);
    }

	public static String getMensagemCnpj(String campo) {
        return String.format(CNPJ_NULO, campo);
    }
}
