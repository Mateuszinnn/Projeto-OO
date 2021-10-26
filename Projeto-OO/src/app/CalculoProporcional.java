package app;

import javax.swing.JOptionPane;

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
		JOptionPane.showMessageDialog(null, preco);
		JOptionPane.showMessageDialog(null, rendaTotal);
		
			return ((preco*100)/rendaTotal)*rendaPessoal;
	// totRendimentoFloat - 100%
	// valorFinal         - porcentagem
	//resultPorcentagem = totRendimentoFloat * porcentagem = valorFinal * 100;
	//resultProporcional = porcentagem * Rendimento;
	}
}
