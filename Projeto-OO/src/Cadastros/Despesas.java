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
	
	public Despesas(String descricao, String categoria, int str) {
		this.descricao = descricao;
		this.valor = str;
		this.categoria = categoria;
	}

	public Despesas() {
		despesas = new LinkedList<Despesas>();
	}

	public Despesas(String descricao2, String categoria2, String string) {
		// TODO Auto-generated constructor stub
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
		 categoria = JOptionPane.showInputDialog("Informe a categoria da despesa(Agua,luz,telefonia,etc):");
		 String str = JOptionPane.showInputDialog("informe o valor da despesa: ");
		 valor = Integer.parseInt(str);
		 valorFinal = valor + valorFinal;
		 
		 Despesas d = new Despesas(descricao,categoria,valor); 
		 
		 boolean resposta = despesas.add(d);
			if (resposta) 
				JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
			
			return;
	}
	
	public String toString() {
		return "<" + descricao + ">;<" + categoria + ">;<" + valor + ">;";
	}
	public String toStringValor(int valor){
		return " " + valor;
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
	public void lerDespesas() {
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(nomeArquivo);
			
			byte[] conteudoArquivo = in.readAllBytes();
			
			
			String cadastro = "";
			for (int i=0; i<conteudoArquivo.length; i++) {
				cadastro += (char)conteudoArquivo[i];
			}
			
			
			String[] strDespesas = cadastro.split("\n");
			
			
			for (String als : strDespesas) {
				String[] str = als.split(";");
				Despesas d = new Despesas(str[0], str[1], str[2]);
				despesas.add(d);
			}
		} catch (IOException e) {
			
		}
	}
}
