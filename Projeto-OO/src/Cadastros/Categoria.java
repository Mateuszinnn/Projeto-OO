package Cadastros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Categoria {
	protected String descricao;
	private List<String> subCategorias = new ArrayList<String>();

	public Categoria(String descricao, List<String> subCategoria) {
		this.descricao = descricao;
		this.subCategorias = subCategoria;
	}

	public String getNomeSubCategoria(int index) {
		return subCategorias.get(index);
	}
	public void gravarCategoria() {
        Functions.gravarArquivo("categorias.txt", toString());
    }

	public void cadastrarCategoria() {
        String subCategoria, option;
        Boolean isValid = false;

        this.descricao = JOptionPane.showInputDialog("Informe a descrição da categoria:");

        do {

            if (this.subCategorias.size() == 0) {
                option = JOptionPane.showInputDialog("Gostaria de Cadastrar uma subcategoria?\n1) - Sim\n2) - Não");
            } else {
                option = JOptionPane.showInputDialog("Gostaria de Cadastrar outra subcategoria?\n1) - Sim\n2) - Não");
            }

            isValid = Functions.isInteger(option, "Opção inválida! Tente novamente");

            if (isValid) {
                if (Functions.rangeOfValues(1, 2, Integer.parseInt(option))) {
                    if (Integer.parseInt(option) == 1) {
                        subCategoria = JOptionPane.showInputDialog("Digite a descrição da subcategoria: ");
                        this.subCategorias.add(subCategoria);
                        isValid = false;
                    }
                } else {
                    isValid = false;
                }
            }

        } while (!isValid);

        if (isValid) {
            JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso");
            gravarCategoria();
        }
    }


}
