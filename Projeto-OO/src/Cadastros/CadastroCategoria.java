package Cadastros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroCategoria {
	List<Categoria> categorias;
	List<String> subcategorias = new ArrayList<String>();

	public CadastroCategoria() {
		categorias = new ArrayList<Categoria>();
	}

	public void cadastrarCategoria() {
		String descricao = JOptionPane.showInputDialog("Infome a descrição da Categoria: ");
		String subcategoria;
		int optionInt;

		do {

			String option = JOptionPane.showInputDialog("Gostaria de Cadastrar uma subcategorias?\n1) - Sim\n2) - Não");
			optionInt = Integer.parseInt(option);

			if (optionInt != 1 || optionInt != 2) {

			}

			switch (optionInt) {
			case 1:
				subcategoria = JOptionPane.showInputDialog("Digite o nome da subcategoria: ");
				subcategorias.add(subcategoria);
				break;
			case 2:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida, digite outro valor");
				break;
			}

		} while (optionInt != 1 || optionInt != 2);

		Categoria c = new Categoria(descricao, subcategorias);
		categorias.add(c);
	}
}
