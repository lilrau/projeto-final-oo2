package utfp.POO2.ProjetoFinal.Entity;

public class Conta {
	
	private String nomeBanco;
	private int agencia;
	private int numeroConta;
	private double saldoInicial;
	private String tipoConta;

	public Conta(String nomeBanco, int agencia, int numeroConta, double saldoInicial, String tipoConta) {
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldoInicial = saldoInicial;
		this.tipoConta = tipoConta;
	}
	public Conta() {
		
	}

	private int codConta;

	public int getCodConta() {
		return codConta;
	}

	public void setCodConta(int codConta) {
		this.codConta = codConta;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

}
