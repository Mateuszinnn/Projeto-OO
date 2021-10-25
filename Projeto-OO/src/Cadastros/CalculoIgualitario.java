package Cadastros;

public class CalculoIgualitario extends Calculos{
	private float numPessoasIgualitario;
	private float valorFinalIgualitario;
	
	public CalculoIgualitario(float numPessoasIgualitario, float valorFinalIgualitario) {
		this.numPessoasIgualitario = numPessoasIgualitario;
		this.valorFinalIgualitario = valorFinalIgualitario;
		
	}
	
	@Override
	public float calculoRegraIgualitaria() {
		return valorFinalIgualitario/numPessoasIgualitario;
	}
}
