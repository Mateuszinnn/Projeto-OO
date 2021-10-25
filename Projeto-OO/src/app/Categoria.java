package app;

import javax.swing.JOptionPane;

public class Categoria {
	protected String subCategoria;
	
	
	
	public Categoria() {
		
	}

	public String getNomeSubCategoria() {
		return subCategoria;
	}

//Metodos especiais
	public void cadastrarCategoria() {
		 Categoria[] categorias = new Categoria[0];
		 subCategoria = JOptionPane.showInputDialog("Informe o nome da subcategoria de");
		 
		 Categoria c = new Categoria();
		 
		 Categoria[] tempC = new Categoria[categorias.length+1];
			for (int i=0; i<categorias.length; i++) {
				tempC[i] = categorias[i];
			}
			tempC[categorias.length] = c;
			
			categorias = tempC;
	}
}
