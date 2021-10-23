package Cadastros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Categoria {
	protected String descricao;
	protected List<String> subCategoria = new ArrayList<String>();

	public Categoria(String descricao, List<String> subCategoria) {
		this.descricao = descricao;
		this.subCategoria = subCategoria;
	}

}
