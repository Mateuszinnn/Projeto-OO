package app;

public class CalculoProporcional extends Calculos{

	public CalculoProporcional(Pessoas renda, Despesas preco) {
		//totRendimento = renda;
		preco = preco;
	}
	@Override
	public float calculoRegraProporcional() {
		return resultProporcional;
	// totRendimentoFloat - 100%
	// valorFinal         - porcentagem
	//resultPorcentagem = totRendimentoFloat * porcentagem = valorFinal * 100;
	//resultProporcional = porcentagem * Rendimento;
	}
}
