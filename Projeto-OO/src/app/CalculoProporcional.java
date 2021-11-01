package app;
 
public class CalculoProporcional extends Calculos{
   private float rendaTotal; // valor total, somatorio de todas as pessoas
   private double despesa; // valor total da despesa
   private double porcentagem; // porcentagem a ser calculada em cima do rendimento de cada pessoa
 
   public CalculoProporcional(float rendaTotal, double d) {
       this.despesa = d;
       this.rendaTotal = rendaTotal;
   }
   
   @Override
   public double calculoRegraProporcional() {
	    porcentagem = despesa/rendaTotal;
		return porcentagem;
  
   }
}
