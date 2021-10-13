package app;

import javax.swing.JOptionPane;

public class Calculos implements Formulas_Calculo_Renda {
	protected Pessoas renda;
	protected Despesas preco;
	protected float resultIgualitario;
	protected float resultProporcional;
	
	public Calculos() {
		// TODO Auto-generated constructor stub
	}
	public Pessoas getRenda() {
		return renda;
	}


	public void setRenda(Pessoas renda) {
		this.renda = renda;
	}


	public Categoria getPreco() {
		return preco;
	}


	public void setPreco(Despesas preco) {
		this.preco = preco;
	}


	public void emitirPagamentos(){
		//if()
	}
	@Override
	public float calculoRegraIgualitaria() {
		return resultIgualitario;
	}
	@Override
	public float calculoRegraProporcional() {
		return resultProporcional;
		// TODO Auto-generated method stub
		//resultProporcional = 
	}
}
