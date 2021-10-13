package app;

import javax.swing.JOptionPane;

public class Calculos implements Formulas_Calculo_Renda {
	private Pessoas renda;
	private Despesas preco;
	private float resultIgualitario;
	private float resultProporcional;
	
	public Calculos(Pessoas renda, Despesas preco) {
		this.renda = renda;
		this.preco = preco;
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
