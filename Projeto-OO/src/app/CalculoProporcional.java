package app;
 
import javax.swing.JOptionPane;
 
public class CalculoProporcional extends Calculos{
   private float rendaPessoal; // valor recebido individualmente
   private float rendaTotal; // valor total, somatório de todas as pessoas
   private float despesa; // valor total da despesa
   // private float porcentagem;
 
   public CalculoProporcional(float rendaPessoal, float rendaTotal, float despesa) {
       this.rendaPessoal = rendaPessoal;
       this.rendaTotal = rendaTotal;
       this.despesa = despesa;
   }
   @Override
   public float calculoRegraProporcional() {
           return (rendaPessoal*despesa)/rendaTotal;
   // totRendimentoFloat - 100%
   // valorFinal         - porcentagem
   //resultPorcentagem = totRendimentoFloat * porcentagem = valorFinal * 100;
   //resultProporcional = porcentagem * Rendimento;
   }
}
