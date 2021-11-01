package app;

public class CalculoIgualitario extends Calculos{
	private float numPessoasIgualitario;
	private double valorFinalIgualitario;
	
	public CalculoIgualitario(float numPessoasIgualitario, double d) {
		this.numPessoasIgualitario = numPessoasIgualitario;
		this.valorFinalIgualitario = d;
	}
	
	@Override
	public double calculoRegraIgualitaria() {
		return valorFinalIgualitario/numPessoasIgualitario;
	}
}
