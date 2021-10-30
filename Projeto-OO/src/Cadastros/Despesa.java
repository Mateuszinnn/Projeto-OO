package Cadastros;

import java.io.BufferedWriter;
import java.time.YearMonth;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Despesa {

	private String descricao;
	private double valor;
	private Categoria categoria = new Categoria();
	int year;
	int month;

	public Despesa() {

	}

	public Despesa(String descricao, double valor, Categoria categoria, int year, int month) {
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
		this.year = year;
		this.month = month;
	}

	public float getValorFinal() {
		return valorFinal;
	}

	// Metodos especiais
	public void cadastrarDespesa() {
		this.descricao = JOptionPane.showInputDialog("Informe a descrição da Despesa: ");
		String value;
		Boolean isValid = true;
		int optionInt;

		do {
			value = JOptionPane.showInputDialog("Informe o valor da despesa: ");

			if (Functions.isDouble(value, "O valor digitado não é válido\nPor favor, tente novamente")) {
				this.valor = Double.parseDouble(value);
				isValid = true;
			} else {
				isValid = false;
			}

		} while (!isValid);

		String fileText = Functions.lerArquivo("categorias.txt");

		if (fileText.isEmpty()) {
			isValid = false;

			do {

				String option = JOptionPane.showInputDialog(
						"Não encontramos nenhuma categoria cadastrada.\nGostaria de realizar o cadastro?\n1) - Sim\n2) - Não");

				isValid = Functions.isInteger(option, "Opção inválida! Tente novamente");

				if (isValid) {
					optionInt = Integer.parseInt(option);

					if (Functions.rangeOfValues(1, 2, optionInt)) {
						if (optionInt == 1) {
							this.categoria.cadastrarCategoria();

							do {
								option = JOptionPane.showInputDialog(
										"Gostaria de prosseguir com o cadastramento da despesa?\n 1) Sim\n2) Não");
								isValid = Functions.isInteger(option, "Opção inválida! Tente novamente");

								if (isValid) {
									if (Functions.rangeOfValues(1, 2, optionInt)) {
										if (Integer.parseInt(option) == 1) {
											cadastrarDespesa();
											gravarDespesa();
											return;
										} else {
											return;
										}
									} else {
										isValid = false;
									}
								}

							} while (!isValid);

						} else {
							System.exit(0);
						}

					} else {
						isValid = false;
					}
				}

			} while (!isValid);

		}

		String ImprimirCategorias = "";
		int index = 1;
		String[] columnsFile;
		String[] fileLines = fileText.split("\n");
		for (String lines : fileLines) {
			columnsFile = lines.split(";");
			ImprimirCategorias = ImprimirCategorias + index + ") " + columnsFile[0] + "\n";
			index++;
		}
		ImprimirCategorias = ImprimirCategorias + (index) + ") " + "Cadastrar nova categoria" + "\n";

		String option;

		do {
			option = JOptionPane.showInputDialog("Escolha a categoria desejada: \n" + ImprimirCategorias);

			isValid = Functions.isInteger(option, "Opção inválida! Tente novamente");

			if (isValid) {
				if (Functions.rangeOfValues(1, index, Integer.parseInt(option))) {
					if (Integer.parseInt(option) == index) {
						categoria.cadastrarCategoria();
						JOptionPane.showMessageDialog(null, "Escolha a categoria novamente");

						fileText = Functions.lerArquivo("categorias.txt");

						ImprimirCategorias = "";
						index = 1;
						fileLines = fileText.split("\n");
						for (String lines : fileLines) {
							columnsFile = lines.split(";");
							ImprimirCategorias = ImprimirCategorias + index + ") " + columnsFile[0] + "\n";
							index++;
						}

						do {
							option = JOptionPane.showInputDialog("Escolha uma categoria: \n" + ImprimirCategorias);

							isValid = Functions.isInteger(option, "Opção inválida! Tente novamente");

							if (isValid) {
								optionInt = Integer.parseInt(option);

								if (Functions.rangeOfValues(1, fileLines.length, optionInt)) {
									columnsFile = fileLines[optionInt - 1].split(";");
									this.categoria.setDescricao(columnsFile[0]);
									isValid = true;
								} else {
									isValid = false;
								}
							}

						} while (!isValid);

						String[] subCategorias = fileLines[Integer.parseInt(option) - 1].split(";");

						if (subCategorias.length > 1) {
							String ImprimirSubCategorias = "";
							index = 1;

							for (String columns : subCategorias) {
								if (index != 1) {
									ImprimirSubCategorias = ImprimirSubCategorias + (index - 1) + ") " + columns + "\n";
								}

								index++;
							}

							do {
								option = JOptionPane
										.showInputDialog("Escolha uma subcategoria: \n" + ImprimirSubCategorias);

								isValid = Functions.isInteger(option, "Opção inválida! Tente novamente");

								if (isValid) {
									optionInt = Integer.parseInt(option);

									if (Functions.rangeOfValues(1, (subCategorias.length - 1), optionInt)) {
										this.categoria.setDescricao(subCategorias[optionInt]);
										isValid = true;
									} else {
										isValid = false;
									}
								}

							} while (!isValid);
						}

						gravarDespesa();
						return;
					} else {
						isValid = true;
					}
				} else {
					isValid = false;
				}
			}

		} while (!isValid);

		String ImprimirSubCategorias = "";
		index = 1;
		String[] subCategorias = fileLines[Integer.parseInt(option) - 1].split(";");

		this.categoria.setDescricao(subCategorias[0]);

		if (subCategorias.length > 1) {
			for (String columns : subCategorias) {
				if (index != 1) {
					ImprimirSubCategorias = ImprimirSubCategorias + (index - 1) + ") " + columns + "\n";
				}
				index++;
			}

			do {
				option = JOptionPane.showInputDialog("Escolha uma subcategoria: \n" + ImprimirSubCategorias);

				isValid = Functions.isInteger(option, "Opção inválida! Tente novamente");

				if (isValid) {
					optionInt = Integer.parseInt(option);

					if (Functions.rangeOfValues(1, (subCategorias.length - 1), optionInt)) {
						this.categoria.setDescricao(subCategorias[optionInt]);
						isValid = true;
					} else {
						isValid = false;
					}
				}

			} while (!isValid);

		}

		if (isValid) {
			JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
			gravarDespesa();
		}
	}

	@Override
	public String toString() {
		return descricao + ";" + this.categoria.getDescricao() + ";" + valor;
	}

	public void gravarDespesa() {
		Functions.gravarArquivo("despesas.txt", toString());
	}

	public void lerDespesas() {
		FileInputStream in = null;

		try {
			in = new FileInputStream(nomeArquivo);

			byte[] conteudoArquivo = in.readAllBytes();

			String cadastro = "";
			for (int i = 0; i < conteudoArquivo.length; i++) {
				cadastro += (char) conteudoArquivo[i];
			}

			String[] strDespesas = cadastro.split("\n");
			for (String als : strDespesas) {
				String[] str = als.split(";");
				Despesa a = new Despesa(str[0], str[1], str[2]);
				despesas.add(a);
			}
		} catch (IOException e) {
		}
	}
}
