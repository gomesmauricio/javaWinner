package entidade;

public class RetornoCalculadora {
	private int codigoRetorno; // 0-Sucesso 1-Falha
	private String mensagemRetorno;
	private double valorRetorno;

	public int getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(int codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}

	public double getValorRetorno() {
		return valorRetorno;
	}

	public void setValorRetorno(double valorRetorno) {
		this.valorRetorno = valorRetorno;
	}
}
