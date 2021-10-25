package app;

import javax.swing.JOptionPane;
import Cadastros.Pessoas;
import Cadastros.Despesas;
import Cadastros.CalculoIgualitario;
import Cadastros.Categoria;

public class Main_App {

	static Pessoas pessoa= new Pessoas();
	static Despesas despesa = new Despesas();
	static Categoria categoria= new Categoria();
	static CalculoIgualitario calculoI= new CalculoIgualitario(0, 0);

	public static void main(String[] args){
		
		int opcao;
		pessoa.lerAlunos();
		despesa.lerDespesas();
		do { 
			String strOpcao = JOptionPane.showInputDialog("Bem vindo ao App da Rep�blica! \n\n"
					+ "Escolha uma op��o: \n\n"
					+ "1 - Cadastrar Pessoas\n"
					+ "2 - Cadastrar Despesas\n"
					+ "3 - Cadastrar Categoria\n"
					+ "4 - Calcular reparti��o de despesas - Regra igualit�ria\n"
					+ "5 - Calcular reparti��o de despesas - Regra proporcional\n"
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
				
				break;
			case 0: 
				//sair do programa
				break;

			default:
				//Opcao invalida
				JOptionPane.showMessageDialog(null, "Opc�o Inv�lida!");
				break;
			}
		} while (opcao != 0);
		
	}


}
