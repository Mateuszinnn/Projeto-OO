package Calculos;

import Cadastros.Despesas;
import Cadastros.Pessoas;

public class CalculoIgualitario extends Calculos{

	public CalculoIgualitario(int numPessoasIgualitario, float valorFinalIgualitario ) {
		this.despesas.valorFinal = valorFinalIgualitario;
		this.pessoas.numPessoas = numPessoasIgualitario;
		
	}
	public CalculoIgualitario() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public float calculoRegraIgualitaria() {
		resultIgualitario = this.despesas.getValorFinal()/this.pessoas.getNumPessoas();
		
		return resultIgualitario;
	}
}
