package app;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import Exceptions.DescricaoNaoInformadaException;
import Exceptions.ValorNaoInformadoException;
import java.time.YearMonth;

public class Despesas {

	private String descricao;
	private double valor;
	private Categoria categoria = new Categoria();
	int year = YearMonth.now().getYear();
	int month = YearMonth.now().getMonthValue();
	String nomeArquivo = "despesas" + "_" + month + "_" + year + ".txt";
	List<Despesas> despesas;
	private double valorFinal = 0;

	public Despesas() {
		despesas = new LinkedList<Despesas>();
	}

	public Despesas(String descricao, double valor, Categoria categoria, int year, int month) {
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
		this.year = year;
		this.month = month;
	}

	// public float getValorFinal() {
	// return valorFinal;
	// }

	// Metodos especiais
	public void cadastrarDespesas() {
		String value;
		Boolean isValid = true;
		int optionInt;

		do {

			try {
				this.descricao = JOptionPane.showInputDialog("Informe a descri��o da Despesa: ");
				verificarDescricao(this.descricao, "Informe uma descri��o v�lida.");
				isValid = true;

			} catch (DescricaoNaoInformadaException e) {
				isValid = false;
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		} while (!isValid);

		do {
			try {
				value = JOptionPane.showInputDialog("Informe o valor da despesa: ");
				verificarValor(value, "Valor inv�lido!!!\nPor favor, tente novamente.");
				valor = Double.parseDouble(value);
				valorFinal = valor + valorFinal;
				isValid = true;

			} catch (ValorNaoInformadoException e) {
				isValid = false;
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} while (!isValid);

		String fileText = Functions.lerArquivo("categorias.txt");

		if (fileText.isEmpty()) {
			isValid = false;

			do {

				String option = JOptionPane.showInputDialog(
						"N�O encontramos nenhuma categoria cadastrada.\nGostaria de realizar o cadastro?\n1) - Sim\n2) - N�O");

				isValid = Functions.isInteger(option, "Op��o inv�lida! Tente novamente");

				if (isValid) {
					optionInt = Integer.parseInt(option);

					if (Functions.rangeOfValues(1, 2, optionInt)) {
						if (optionInt == 1) {
							// Todo Criar exception CategoriaNaoInformadaException.
							this.categoria.cadastrarCategoria();

							do {
								option = JOptionPane.showInputDialog(
										"Gostaria de prosseguir com o cadastramento da despesa?\n ) Sim\n2) N�O");
								isValid = Functions.isInteger(option, "Op��o inv�lida! Tente novamente");

								if (isValid) {
									if (Functions.rangeOfValues(1, 2, optionInt)) {
										if (Integer.parseInt(option) == 1) {
											cadastrarDespesas();
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
							return;
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

			try {
				isValid = Functions.isInteger(option, "Op��o inv�lida! Tente novamente");
			} catch (DescricaoNaoInformadaException e) {
				isValid = false;
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

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

							isValid = Functions.isInteger(option, "Op��o inv�lida! Tente novamente");

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

								isValid = Functions.isInteger(option, "Op��o inv�lida! Tente novamente");

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
						this.month = Functions.pegarMes();
						this.year = Functions.pegarAno();
						JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
						gravarDespesas(this.month, this.year);
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

				isValid = Functions.isInteger(option, "Op��o inv�lida! Tente novamente");

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

		this.month = Functions.pegarMes();
		this.year = Functions.pegarAno();

		if (isValid) {
			JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
			gravarDespesas(this.month, this.year);
		}
	}

	@Override
	public String toString() {
		return descricao + ";" + this.categoria.getDescricao() + ";" + valor;
	}

	public void gravarDespesas(int month, int year) {
		Functions.gravarArquivo("despesas" + "_" + month + "_" + year + ".txt", toString());
	}

	public void verificarDescricao(String descricao, String mensagem) throws DescricaoNaoInformadaException {
		if (descricao.isBlank()) {
			throw new DescricaoNaoInformadaException(mensagem);
		}
	}

	public void verificarValor(String valor, String mensagem) {
		if (!(Functions.isDouble(valor))) {
			throw new ValorNaoInformadoException(mensagem);
		}
	}

	public double getValorFinal() {

		return valorFinal;
	}
}