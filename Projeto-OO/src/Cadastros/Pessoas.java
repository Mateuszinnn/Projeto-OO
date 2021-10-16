package Cadastros;

import javax.swing.JOptionPane;

public class Pessoas {
	private String nome;
	private String email;
	private float totRendimento;
	private int numPessoas;
	
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getTotRendimento() {
		return totRendimento;
	}

	public void setTotRendimento(float totRendimento) {
		this.totRendimento = totRendimento;
	}
	public int getNumPessoas() {
		return numPessoas;
	}
//metodos especiais
	public void cadastrarPessoas() {
		Pessoas[] pessoas = new Pessoas[0];
		nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
		email = JOptionPane.showInputDialog("Informe o email da pessoa:");
		String strTotRend = JOptionPane.showInputDialog("Informe o rendimento total da pessoa ");
		float totRendimento = Float.parseFloat(strTotRend);
		this.numPessoas = this.numPessoas++;
		Pessoas p = new Pessoas(nome,email,totRendimento);
		
		Pessoas[] tempP = new Pessoas[pessoas.length+1];
		for (int i=0; i<pessoas.length; i++) {
			tempP[i] = pessoas[i];
		}
		tempP[pessoas.length] = p;
		
		pessoas = tempP;
		
	}
}
