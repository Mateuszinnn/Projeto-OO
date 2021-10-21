package Cadastros;

import javax.swing.JOptionPane;

public class Pessoas {
	private String nome;
	private String email;
	private float totRendimento;
	private int numPessoas;
	private float Rendimento;
	
	public Pessoas(String nomePessoa, String emailPessoa, float totRend) {
		this.nome = nomePessoa;
		this.email = emailPessoa;
		this.totRendimento = totRend;
		this.numPessoas = 0;
	}

	public Pessoas() {
		
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public float getTotRendimento() {
		return totRendimento;
	}

	public int getNumPessoas() {
		return numPessoas;
	}
	
//metodos especiais
	public void cadastrarPessoas() {
		Pessoas[] pessoas = new Pessoas[0];
		nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
		email = JOptionPane.showInputDialog("Informe o email da pessoa:");
		Rendimento = Float.parseFloat(JOptionPane.showInputDialog("Informe o rendimento total da pessoa "));
		totRendimento= Rendimento + totRendimento;
		numPessoas = numPessoas+1;
		Pessoas p = new Pessoas(nome,email,totRendimento);
		
		Pessoas[] tempP = new Pessoas[pessoas.length+1];
		for (int i=0; i<pessoas.length; i++) {
			tempP[i] = pessoas[i];
		}
		tempP[pessoas.length] = p;
		
		pessoas = tempP;
		
	}
}
