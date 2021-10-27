package app;
 
import javax.swing.JOptionPane;
 
public class CalculoProporcional extends Calculos{
   private float rendaPessoal; // valor recebido individualmente
   private float rendaTotal; // valor total, somatatorio de todas as pessoas
   private float despesa; // valor total da despesa
   private float porcentagem;
 
   public CalculoProporcional(float Rendimento, float rendaTotal, float despesa) {
       this.rendaPessoal = Rendimento;
       this.rendaTotal = rendaTotal;
       this.despesa = despesa;
   }
   @Override
   public float calculoRegraProporcional() {
	    porcentagem = rendaPessoal/rendaTotal;
		return porcentagem*despesa;
   // totRendimentoFloat - 100%
   // valorFinal         - porcentagem
   //resultPorcentagem = totRendimentoFloat * porcentagem = valorFinal * 100;
   //resultProporcional = porcentagem * Rendimento;
   }
}
