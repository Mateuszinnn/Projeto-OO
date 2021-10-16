package app;

import javax.swing.JOptionPane;
import Cadastros.Pessoas;

public class Main_App {

	public Main_App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		
		int opcao;
		do { 
			String strOpcao = JOptionPane.showInputDialog("Bem vindo ao App da República! \n\n"
					+ "Escolha uma opção: \n\n"
					+ "1 - Cadastrar Pessoas\n"
					+ "2 - Cadastrar Despesas\n"
					+ "3 - Cadastrar Categoria\n"
					+ "0 - Sair do programa");
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				
				break;

			case 2: 
				
				break;

			case 3: 
				
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
