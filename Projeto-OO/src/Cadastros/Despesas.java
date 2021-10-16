package Cadastros;

import javax.swing.JOptionPane;

public class Despesas extends Categoria {
	private String descricao;
	private int valor;
	private String categoria;
	private int valorFinal;
	
	public Despesas(String descricao, int valor, String categoria) {
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}
	

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getValorFinal() {
		return valorFinal;
	}
//Metodos especiais
	public void cadastrarDespesas() {
		 Despesas[] despesas = new Despesas[0];
		 descricao = JOptionPane.showInputDialog("Informe a descrição da despesa(CAESB,CEB,Net,etc):");
		 String strValor = JOptionPane.showInputDialog("informe o valor da despesa: ");
		 valor = Integer.parseInt(strValor);
		 this.valorFinal = this.valor + this.valorFinal;
		 categoria = JOptionPane.showInputDialog("Informe a categoria da despesa(Agua,luz,telefonia,etc):");
		 
		 Despesas d = new Despesas(descricao,valor,categoria);
		 
		 Despesas[] tempD = new Despesas[despesas.length+1];
			for (int i=0; i<despesas.length; i++) {
				tempD[i] = despesas[i];
			}
			tempD[despesas.length] = d;
			
			despesas = tempD;
	}

}
