package app;

import javax.swing.JOptionPane;
import Cadastros.Pessoas;
import Cadastros.Despesas;
import Cadastros.Categoria;
import Calculos.Calculos;

public class Main_App {

	static Pessoas pessoa= new Pessoas();
	static Despesas despesa = new Despesas();
	static Categoria categoria= new Categoria();
	static Calculos calculo= new Calculos();

	public static void main(String[] args){
		
		int opcao;
		do { 
			String strOpcao = JOptionPane.showInputDialog("Bem vindo ao App da República! \n\n"
					+ "Escolha uma opção: \n\n"
					+ "1 - Cadastrar Pessoas\n"
					+ "2 - Cadastrar Despesas\n"
					+ "3 - Cadastrar Categoria\n"
					+ "4 - Calcular repartição de despesas - Regra igualitária\n"
					+ "5 - Calcular repartição de despesas - Regra proporcional\n"
					+ "0 - Sair do programa");
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				pessoa.cadastrarPessoas();
				break;

			case 2: 
				despesa.cadastrarDespesas();
				break;
				
			case 3: 
				categoria.cadastrarCategoria();
				break;
				
			case 4:
				JOptionPane.showMessageDialog(null, calculo.calculoRegraIgualitaria());
				break;
				
			case 5:
				
				break;
			case 0: 
				//sair do programa
				break;

			default:
				//Opcao invalida
				JOptionPane.showMessageDialog(null, "Opcão Inválida!");
				break;
			}
		} while (opcao != 0);
		
	}


}
