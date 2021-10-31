package app;
 
import javax.swing.JOptionPane;
 
public class CalculoProporcional extends Calculos{
   private float rendaPessoal; // valor recebido individualmente
   private float rendaTotal; // valor total, somatatorio de todas as pessoas
   private float despesa; // valor total da despesa
   private float porcentagem;
 
   public CalculoProporcional(float rendaTotal, float Despesas) {
       this.despesa = Despesas;
       this.rendaTotal = rendaTotal;
   }
   @Override
   public float calculoRegraProporcional() {
	    porcentagem = despesa/rendaTotal;
		return porcentagem;
   // totRendimentoFloat - 100%
   // valorFinal         - porcentagem
   //resultPorcentagem = totRendimentoFloat * porcentagem = valorFinal * 100;
   //resultProporcional = porcentagem * Rendimento;
   }
}
