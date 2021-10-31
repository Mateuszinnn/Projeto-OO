package app;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Pessoas {
	private String nome;
	private String email;
	public String totRendimento;
	private float totRendimentoFloat;
	public float numPessoas;
	public float Rendimento;
	List<Pessoas> pessoa;
	String nomeArquivo = "alunos.txt";
	public static Pessoas[] P = new Pessoas[0];

	public Pessoas(String nomePessoa, String emailPessoa, float strRendimento) {
		this.nome = nomePessoa;
		this.email = emailPessoa;
		this.Rendimento = strRendimento;
		this.numPessoas = 0;
	}
	
	public Pessoas(String nomePessoa, String emailPessoa, String string) {
		this.nome= nomePessoa;
		this.email= emailPessoa;
		this.totRendimento= string;
	}
	
	public Pessoas() {
		pessoa = new LinkedList<Pessoas>();
	}

	public String getNome() {
		return nome;
	}

	public float getNumPessoas() {
		return numPessoas;
	}

	public float getRendimento() {
		return Rendimento;
	}

	public float getTotRendimentoFloat() {
		return totRendimentoFloat;
	}
	
//metodos especiais
	public void cadastrarPessoas() {
		nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
		email = JOptionPane.showInputDialog("Informe o email da pessoa:");
		totRendimento = JOptionPane.showInputDialog("Informe o rendimento total da pessoa ");
		Rendimento = Float.parseFloat(totRendimento);
		totRendimentoFloat= Rendimento + totRendimentoFloat;
		numPessoas = numPessoas+1;
		
		Pessoas p = new Pessoas(nome,email,Rendimento);
		Pessoas s = new Pessoas(nome,email,totRendimento);
		Pessoas[] rendP = new Pessoas[P.length+1];
		
		for (int i=0; i<P.length; i++) {
			rendP[i] = P[i];  //copiando todas referencias de pessoas em rendP
		}
		rendP[P.length] = p;
		P = rendP;
		boolean resposta = pessoa.add(p);
		pessoa.add(s);
		if (resposta) 
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
		return;
	}
	
	public String toString() {
		return "" + nome + ";" + email + ";" + totRendimento + ";";
	}
	
	public void gravarAlunos() {
		BufferedWriter buffer = null;
		FileWriter out = null;
		
		try {
			out = new FileWriter(nomeArquivo);
			buffer = new BufferedWriter(out);
			
			for (Pessoas s : pessoa) {
				buffer.write(s.toString());
				buffer.write('\n');
			}
			
			buffer.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}	
	
	public void lerAlunos() {
		FileInputStream in = null;  
		try {
			in = new FileInputStream(nomeArquivo); 
			
			byte[] conteudoArquivo = in.readAllBytes();
		
			String cadastro = "";
			for (int i=0; i<conteudoArquivo.length; i++) {
				cadastro += (char)conteudoArquivo[i];
			}
			
			String[] strAlunos = cadastro.split("\n");
			for (String als : strAlunos) {
				String[] str = als.split(";");
				Pessoas s = new Pessoas(str[0], str[1], str[2]);
				pessoa.add(s);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
