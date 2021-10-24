package Calculos;

import Cadastros.Despesas;
import Cadastros.Pessoas;

public class CalculoProporcional extends Calculos{

	public CalculoProporcional(Pessoas renda, Despesas preco) {
		//totRendimento = renda;
		preco = preco;
	}
	@Override
	public float calculoRegraProporcional() {
		return resultProporcional;
	//resultProporcional = 
	}
}
