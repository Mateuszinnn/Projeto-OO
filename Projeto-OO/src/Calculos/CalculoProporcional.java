package Calculos;

import Cadastros.Despesa;
import Cadastros.Pessoas;

public class CalculoProporcional extends Calculos {

	public CalculoProporcional(Pessoas renda, Despesa preco) {
		// totRendimento = renda;
		preco = preco;
	}

	@Override
	public float calculoRegraProporcional() {
		return resultProporcional;
		// resultProporcional =
	}
}
