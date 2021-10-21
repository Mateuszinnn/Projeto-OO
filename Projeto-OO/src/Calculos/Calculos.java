package Calculos;

import javax.swing.JOptionPane;

import Cadastros.Categoria;
import Cadastros.Despesas;
import Cadastros.Pessoas;

public class Calculos implements Formulas_Calculo_Renda {
	protected Pessoas renda;
	protected Despesas preco;
	protected float resultIgualitario;
	protected float resultProporcional;
	
	public Calculos() {
	}
	public Pessoas getRenda() {
		return renda;
	}

	public Categoria getPreco() {
		return preco;
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
		//resultProporcional = 
	}
}
