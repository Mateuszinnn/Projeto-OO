package app;

public class CalculoProporcional extends Calculos{
	private float rendaPessoal;
	private float rendaTotal;
	private float preco;

	public CalculoProporcional(float rendaPessoal, float rendaTotal, float preco) {
		this.rendaPessoal = rendaPessoal;
		this.rendaTotal = rendaTotal;
		this.preco = preco;
	}
	@Override
	public float calculoRegraProporcional() {
		return ((rendaPessoal*100)/rendaTotal)*preco;
	// totRendimentoFloat - 100%
	// valorFinal         - porcentagem
	//resultPorcentagem = totRendimentoFloat * porcentagem = valorFinal * 100;
	//resultProporcional = porcentagem * Rendimento;
	}
}
