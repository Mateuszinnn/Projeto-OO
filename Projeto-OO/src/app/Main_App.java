package app;

import javax.swing.JOptionPane;
import Cadastros.Pessoas;
import Cadastros.Despesas;
import Cadastros.Categoria;

public class Main_App {

	static Pessoas pessoa= new Pessoas();
	static Despesas despesa = new Despesas();
	static Categoria categoria= new Categoria();

	public static void main(String[] args){
		
		int opcao;
		do { 
			String strOpcao = JOptionPane.showInputDialog("Bem vindo ao App da Rep�blica! \n\n"
					+ "Escolha uma op��o: \n\n"
					+ "1 - Cadastrar Pessoas\n"
					+ "2 - Cadastrar Despesas\n"
					+ "3 - Cadastrar Categoria\n"
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
