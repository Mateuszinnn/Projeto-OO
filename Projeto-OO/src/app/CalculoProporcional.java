package app;

import javax.swing.JOptionPane;

public class CalculoProporcional extends Calculos{
	private float rendaPessoal;
	private float rendaTotal;
	private float preco;
	private int i;
	private float numPessoa;

	public CalculoProporcional(float rendaPessoal, float rendaTotal, float preco, float numPessoa) {
		this.rendaPessoal = rendaPessoal;
		this.rendaTotal = rendaTotal;
		this.preco = preco;
		this.numPessoa = numPessoa;
	}
	@Override
	public float calculoRegraProporcional() {
		JOptionPane.showMessageDialog(null, preco);
		JOptionPane.showMessageDialog(null, rendaTotal);
		for(i=0; i<numPessoa; i++) {
			return ((preco*100)/rendaTotal)*rendaPessoal;
		}
		return -1;
	// totRendimentoFloat - 100%
	// valorFinal         - porcentagem
	//resultPorcentagem = totRendimentoFloat * porcentagem = valorFinal * 100;
	//resultProporcional = porcentagem * Rendimento;
	}
}
