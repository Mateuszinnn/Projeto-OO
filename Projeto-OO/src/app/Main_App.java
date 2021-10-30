package app;

import javax.swing.JOptionPane;
import Cadastros.Pessoas;
import Cadastros.Despesa;
import Cadastros.Categoria;
import Calculos.CalculoIgualitario;

public class Main_App {

	static Pessoas pessoa = new Pessoas();
	static Despesa despesa = new Despesa();
	static Categoria categoria = new Categoria();
	static CalculoIgualitario calculoI = new CalculoIgualitario();

	public static void main(String[] args) {

		int opcao;
		pessoa.lerAlunos();
		despesa.lerDespesas();
		do {
			String strOpcao = JOptionPane.showInputDialog("Bem vindo ao App da Rep�blica! \n\n"
					+ "Escolha uma op��o: \n\n" + "1 - Cadastrar Pessoas\n" + "2 - Cadastrar Despesas\n"
					+ "3 - Cadastrar Categoria\n" + "4 - Calcular reparti��o de despesas - Regra igualit�ria\n"
					+ "5 - Calcular reparti��o de despesas - Regra proporcional\n" + "0 - Sair do programa");
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
				JOptionPane.showMessageDialog(null, calculoI.calculoRegraIgualitaria());
				break;

			case 5:

				break;
			case 0:
				// sair do programa
				break;

			default:
				// Opcao invalida
				JOptionPane.showMessageDialog(null, "Opc�o Inv�lida!");
				break;
			}
		} while (opcao != 0);

	}

}
