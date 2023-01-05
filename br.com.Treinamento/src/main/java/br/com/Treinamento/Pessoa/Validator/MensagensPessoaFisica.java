package br.com.Treinamento.Pessoa.Validator;

public class MensagensPessoaFisica {

	public static final String PREENCHIMENTO_OBRIGATORIO = "O campo %s é de preenchimento obrigatório";
	public static final String RG_NULO = "O campo do rg não pode ser nulo";
	public static final String NASC_NULO = "O campo de nascimento não pode ser nulo";
	
	public static String getMensagemCampoObrigatorio(String campo) {
        return String.format(PREENCHIMENTO_OBRIGATORIO, campo);
    }
	
	public static String getMensagemRg(String campo) {
        return String.format(RG_NULO, campo);
    }

	public static String getMensagemNascimento(String campo) {
		return String.format(NASC_NULO, campo);
	}
}
