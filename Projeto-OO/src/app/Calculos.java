package app;

public class Calculos implements Formulas_Calculo_Renda {
	
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
	public double calculoRegraProporcional() {
		return resultProporcional;	
	}
	
	@Override
	public double calculoRegraIgualitaria() {
		return resultIgualitario;
	}
}
