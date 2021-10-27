package ui;

import javax.swing.JOptionPane;

import app.CalculoIgualitario;
import app.CalculoProporcional;
import app.Categoria;
import app.Despesas;
import app.Pessoas;

public class Main_App {
	static Pessoas pessoa= new Pessoas();
	static Despesas despesa = new Despesas();
	static Categoria categoria= new Categoria();
	static CalculoIgualitario calculoI= new CalculoIgualitario(0, 0);
	static CalculoProporcional calculoP= new CalculoProporcional(0, 0, 0);
	private static int i;

	public static void main(String[] args){
		
		int opcao;
		pessoa.lerAlunos();
		despesa.lerDespesas();
		do { 
			String strOpcao = JOptionPane.showInputDialog("Bem vindo ao App da Republica! \n\n"
					+ "Escolha uma opcao: \n\n"
					+ "1 - Cadastrar Pessoas\n"
					+ "2 - Cadastrar Despesas\n"
					+ "3 - Cadastrar Categoria\n"
					+ "4 - Calcular reparticao de despesas - Regra igualitaria\n"
					+ "5 - Calcular reparticao de despesas - Regra proporcional\n"
					+ "0 - Sair do programa");
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				pessoa.cadastrarPessoas();
				pessoa.gravarAlunos();
				
				System.out.println(Pessoas.P[0]);
				break;

			case 2: 
				despesa.cadastrarDespesas();
				despesa.gravarDespesas();
				break;
				
			case 3: 
				categoria.cadastrarCategoria();
				break;
				
			case 4:
				CalculoIgualitario cI = new CalculoIgualitario(pessoa.getNumPessoas(),despesa.getValorFinal());
				JOptionPane.showMessageDialog(null, cI.calculoRegraIgualitaria());
				break;
				
			case 5:
				for(int i=0; i<Pessoas.P.length;i++) {
					CalculoProporcional cP = new CalculoProporcional(Pessoas.P[i].getRendimento(),Pessoas.P[i].getTotRendimentoFloat(), despesa.getValorFinal());
					//System.out.println(Pessoas.P[i][2]);
					//var x = pessoa.lerAlunos();
					//System.out.println(x);
					System.out.println(Pessoas.P[i].getRendimento());
					//System.out.println(Pessoas.P[i].gettotRendimentoFloat());
					//System.out.println(despesa.getValorFinal());
					
					String resposta =  Pessoas.P[i].getNome()+" tera de pagar: "+ cP.calculoRegraProporcional()+" reais\n";
					JOptionPane.showMessageDialog(null, resposta);
				}
				//CalculoProporcional cP = new CalculoProporcional(pessoa.getRendimento(), pessoa.getTotRendimentoFloat(), despesa.getValorFinal(),pessoa.getNumPessoas());
	
				break;
			case 0: 
				//sair do programa
				break;

			default:
				//Opcao invalida
				JOptionPane.showMessageDialog(null, "Opcao Invalida!");
				break;
			}
		} while (opcao != 0);
		
		
	}


}
