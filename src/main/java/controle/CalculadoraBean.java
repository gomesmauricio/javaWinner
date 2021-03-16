package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import util.JpaUtil;

@ManagedBean(name = "CalculadoraBean")
@RequestScoped
public class CalculadoraBean {

	private double valor1, valor2, resultado;

	public void somar() {
		System.out.println("-- somar --");
		this.resultado = this.valor1 + this.valor2;
		JpaUtil.getEntityManager();
	}

	public double getValor1() {
		return valor1;
	}

	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}

	public double getValor2() {
		return valor2;
	}

	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
}
