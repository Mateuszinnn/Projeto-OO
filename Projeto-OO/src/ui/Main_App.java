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
	static CalculoProporcional calculoP= new CalculoProporcional(0, 0, 0, 0);
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
				CalculoProporcional cP = new CalculoProporcional(pessoa.getRendimento(), pessoa.getTotRendimentoFloat(), despesa.getValorFinal(),pessoa.getNumPessoas());
				JOptionPane.showMessageDialog(null, cP.calculoRegraProporcional());
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
