package Cadastros;

import java.io.BufferedWriter;
import java.time.YearMonth;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Despesas extends Categoria {
	private String descricao;
	private String valor;
	private String categoria;
	private float valorFloat;
	public float valorFinal;
	int year = YearMonth.now().getYear();
	int month = YearMonth.now().getMonthValue();
	List<Despesas> despesas;
	String nomeArquivo = "despesas"+"_"+month+"_"+year+".txt";
	
	public Despesas(String descricao, String categoria, String str) {
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = str;
	}

	public Despesas() {
		despesas = new LinkedList<Despesas>();
	}

	public float getValorFinal() {
		return valorFinal;
	}
//Metodos especiais
	public void cadastrarDespesas() {
		 descricao = JOptionPane.showInputDialog("Informe a descrição da despesa(CAESB,CEB,Net,etc):");
		 categoria = JOptionPane.showInputDialog("Informe a categoria da despesa(Agua,luz,telefonia,etc):");
		 String str = JOptionPane.showInputDialog("informe o valor da despesa: ");
		 valor = str;
		 valorFloat = Float.parseFloat(valor);
		 valorFinal = valorFloat + valorFinal;
		 
		 Despesas d = new Despesas(descricao,categoria,str); 
		 
		 boolean resposta = despesas.add(d);
			if (resposta) 
				JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
				JOptionPane.showMessageDialog(null, valorFinal);
			return;
	}
	
	public String toString() {
		return descricao + ";" + categoria + ";" + valor + ";";
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
				Despesas a = new Despesas(str[0], str[1], str[2]);
				despesas.add(a);
			}
		} catch (IOException e) {
		}
	}
}
