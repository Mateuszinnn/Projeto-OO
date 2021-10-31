package app;
 
public class CalculoProporcional extends Calculos{
   private float rendaTotal; // valor total, somatorio de todas as pessoas
   private float despesa; // valor total da despesa
   private float porcentagem; // porcentagem a ser calculada em cima do rendimento de cada pessoa
 
   public CalculoProporcional(float rendaTotal, float Despesas) {
       this.despesa = Despesas;
       this.rendaTotal = rendaTotal;
   }
   
   @Override
   public float calculoRegraProporcional() {
	    porcentagem = despesa/rendaTotal;
		return porcentagem;
  
   }
}
