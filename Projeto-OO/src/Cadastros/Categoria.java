package Cadastros;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	protected String descricao;
	protected List<String> subCategoria = new ArrayList<String>();

	public Categoria(String descricao, List<String> subCategoria) {
		this.descricao = descricao;
		this.subCategoria = subCategoria;
	}

	public String getNomeSubCategoria(int index) {
		return subCategoria.get(index);
	}

}
