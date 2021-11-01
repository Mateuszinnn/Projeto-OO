package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Categoria {
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

    public void lerCategoria() {
        String fileText = Functions.lerArquivo("categorias.txt");

        if (fileText.isEmpty()) {
            Boolean isValid = false;

            do {

                String option = JOptionPane.showInputDialog(
                        "Não encontramos nenhuma categoria cadastrada.\nGostaria de realizar o cadastro?\n1) - Sim\n2) - Não");

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

}
