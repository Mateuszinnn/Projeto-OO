package Calculos;

import Cadastros.Despesas;
import Cadastros.Pessoas;

public class CalculoIgualitario extends Calculos{

	public CalculoIgualitario(int numPessoasIgualitario, int valorFinalIgualitario ) {
		this.despesas.valorFinal = valorFinalIgualitario;
		this.pessoas.numPessoas = numPessoasIgualitario;
		
	}
	@Override
	public float calculoRegraIgualitaria() {
		resultIgualitario = this.despesas.getValorFinal()/this.pessoas.getNumPessoas();
		
		return resultIgualitario;
	}
}
