package app;

import javax.swing.JOptionPane;
import cadastros.Pessoas;
import cadastros.Despesas;
import cadastros.Categoria;
import calculos.Calculos;

public class Main_App {

	static Pessoas pessoa= new Pessoas();
	static Despesas despesa = new Despesas();
	static Categoria categoria= new Categoria();
	static Calculos calculo= new Calculos();

	public static void main(String[] args){
		
		int opcao;
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
				JOptionPane.showMessageDialog(null, calculo.calculoRegraIgualitaria());
				break;
				
			case 5:
				JOptionPane.showMessageDialog(null, calculo.calculoRegraProporcional());
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
