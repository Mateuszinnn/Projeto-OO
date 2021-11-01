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
		nome = JOptionPane.showInputDialog(null,"Informe o nome da pessoa:");
		// verificando se é vazio ou nao
		while(nome.trim().equals("")) {
			if(nome.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "DadosPessoaisIncompletosException");
				nome=JOptionPane.showInputDialog(null,"é necessario o preenchimento, tente de novo:");
			}
		}
		
		email = JOptionPane.showInputDialog("Informe o email da pessoa:");
		// verificando se é vazio ou nao
		while(email.trim().equals("")) {
			if(email.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "DadosPessoaisIncompletosException");
				email=JOptionPane.showInputDialog(null,"é necessario o preenchimento, tente de novo:");

			}
		}
		
		totRendimento = JOptionPane.showInputDialog("Informe o rendimento total da pessoa ");
		try {
			Rendimento = Float.parseFloat(totRendimento);
		}catch(NumberFormatException e) {
			String mensagem=e.getMessage()+"\n";
			JOptionPane.showMessageDialog(null, mensagem);
			totRendimento = JOptionPane.showInputDialog("Informe o rendimento total da pessoa ");
			Rendimento = Float.parseFloat(totRendimento);
		}
		
	
		totRendimentoFloat= Rendimento + totRendimentoFloat;
		numPessoas = numPessoas+1;
		
		Pessoas p = new Pessoas(nome,email,Rendimento);
		Pessoas[] rendP = new Pessoas[P.length+1];
		
		for (int i=0; i<P.length; i++) {
			rendP[i] = P[i];  //copiando todas referencias de pessoas em rendP
		}
		rendP[P.length] = p;
		P = rendP;
		boolean resposta = pessoa.add(p);
		
		if (resposta) 
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
		return;
	}
	
	public String toString() {
		return "" + nome + ";" + email + ";" + totRendimento + ";";
	}
	
	public void gravarAlunos() {
		Functions.gravarArquivo("alunos.txt", toString());
	}	
}
