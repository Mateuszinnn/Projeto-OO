package Cadastros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroCategoria {
	List<Categoria> categorias;
	
	
	
	public CadastroCategoria() {
		categorias = new ArrayList<Categoria>();
	}



	public void cadastrarCategoria() {
		
		String descricao = JOptionPane.showInputDialog("infome a descrição da Categoria");
		String subcategoria;
		while(true) {
			subcategoria = JOptionPane.showInputDialog("infome a  subCategoria");
		}
		
		
		
		//subcategorias.add(subcategoria);
	}

}
