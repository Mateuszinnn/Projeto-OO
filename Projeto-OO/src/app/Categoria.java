package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Categoria {
<<<<<<< HEAD:Projeto-OO/src/app/Categoria.java
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
=======
    private String descricao;
    private List<String> subCategorias = new ArrayList<String>();

    public Categoria() {
    }

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
                option = JOptionPane.showInputDialog("Gostaria de Cadastrar uma subcategoria?\n 1) - Sim\n 2) - NÃO");
            } else {
                option = JOptionPane.showInputDialog("Gostaria de Cadastrar outra subcategoria?\n 1) - Sim\n 2) - NÃO");
            }

            isValid = Functions.isInteger(option, "Opcão inválida! Tente novamente");

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

    public void lerCategoria() {
        String fileText = Functions.lerArquivo("categorias.txt");

        if (fileText.isEmpty()) {
            Boolean isValid = false;

            do {

                String option = JOptionPane.showInputDialog(
                        "NÃO encontramos nenhuma categoria cadastrada.\n Gostaria de realizar o cadastro?\n1) - Sim\n2) - NÃO");

                isValid = Functions.isInteger(option, "Opção inválida! Tente novamente");

                if (isValid) {
                    if (Functions.rangeOfValues(1, 2, Integer.parseInt(option))) {
                        cadastrarCategoria();
                    } else {
                        isValid = false;
                    }
                }

            } while (!isValid);

        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        String subCategorias = "";

        for (String string : this.subCategorias) {
            subCategorias = subCategorias + string + ";";
        }

        return descricao + ";" + subCategorias;
    }

>>>>>>> Categoria:Projeto-OO/src/Cadastros/Categoria.java
}
