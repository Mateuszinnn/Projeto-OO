package Cadastros;

import java.io.BufferedWriter;
import java.time.YearMonth;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Despesas extends Categoria {
	private String descricao;
	private int valor;
	private String categoria;
	public int valorFinal;
	int year = YearMonth.now().getYear();
	int month = YearMonth.now().getMonthValue();
	
	List<Despesas> despesas;
	
	String nomeArquivo = "despesas"+"_"+month+"_"+year+".txt";
	
	public Despesas(String descricao, int valor, String categoria) {
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
	}

	public Despesas() {
		despesas = new LinkedList<Despesas>();
	}

	public String getDescricao() {
		return descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getValorFinal() {
		return valorFinal;
	}
//Metodos especiais
	public void cadastrarDespesas() {

		 descricao = JOptionPane.showInputDialog("Informe a descrição da despesa(CAESB,CEB,Net,etc):");
		 valor = Integer.parseInt(JOptionPane.showInputDialog("informe o valor da despesa: "));
		 valorFinal = valor + valorFinal;
		 categoria = JOptionPane.showInputDialog("Informe a categoria da despesa(Agua,luz,telefonia,etc):");
		 
		 Despesas d = new Despesas(descricao,valor,categoria);
		 
		 boolean resposta = despesas.add(d);
			if (resposta) 
				JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
			
			return;
	}
	
	public String toString() {
		return "<" + descricao + ">;<" + categoria + ">;<" + valor + ">;";
	}
	
	public void gravarDespesas() {
		BufferedWriter buffer = null;
		FileWriter out = null;
		
		try {
			out = new FileWriter(nomeArquivo);
			buffer = new BufferedWriter(out);
			
			for (Despesas d : despesas) {
				buffer.write(d.toString());
				buffer.write('\n');
			}
			
			buffer.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
