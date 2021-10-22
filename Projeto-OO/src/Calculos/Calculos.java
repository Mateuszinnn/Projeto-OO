package Calculos;

import javax.swing.JOptionPane;

import Cadastros.Categoria;
import Cadastros.Despesas;
import Cadastros.Pessoas;



public class Calculos implements Formulas_Calculo_Renda {
	Pessoas pessoas = new Pessoas();
	Despesas despesas = new Despesas();
	
	//protected Pessoas totRendimento;
	//protected Pessoas numPessoas;
	//protected Despesas valorFinal;
	protected float resultIgualitario;
	protected float resultProporcional;
	
	public Calculos() {
		
	}
	

	public float getResultIgualitario() {
		return resultIgualitario;
	}

	public float getResultProporcional() {
		return resultProporcional;
	}

	@Override
	public float calculoRegraProporcional() {
	return resultProporcional;
	//resultProporcional = 
	}
	@Override
	public float calculoRegraIgualitaria() {
		
		return resultIgualitario;
	}
}
