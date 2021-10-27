package app;

import javax.swing.JOptionPane;

public class CalculoProporcional extends Calculos{
	private float rendaPessoal;
	private float rendaTotal;
	private float preco;
	private float porcentagem;

	public CalculoProporcional(float rendaPessoal, float rendaTotal, float preco) {
		this.rendaPessoal = rendaPessoal;
		this.rendaTotal = rendaTotal;
		this.preco = preco;
	}
	@Override
	public float calculoRegraProporcional() {
		porcentagem= (preco*100)/rendaTotal;
			return (porcentagem/100)*rendaPessoal;
	// totRendimentoFloat - 100%
	// valorFinal         - porcentagem
	//resultPorcentagem = totRendimentoFloat * porcentagem = valorFinal * 100;
	//resultProporcional = porcentagem * Rendimento;
	}
}
