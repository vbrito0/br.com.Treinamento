package br.com.Treinamento.Pessoa.Validator.PF;

public class MensagensPessoaFisica {

	public static final String PREENCHIMENTO_OBRIGATORIO = "O campo %s é de preenchimento obrigatório";
	public static final String RG_NULO = "O campo do rg não pode ser nulo";
	public static final String NASC_NULO = "O campo de nascimento não pode ser nulo";

	public static String getMensagemCampoObrigatorio(String campo) {
        return PREENCHIMENTO_OBRIGATORIO.formatted(campo);
    }

	public static String getMensagemRg(String campo) {
        return RG_NULO.formatted(campo);
    }

	public static String getMensagemNascimento(String campo) {
		return NASC_NULO.formatted(campo);
	}
}
