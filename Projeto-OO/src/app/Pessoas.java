package app;

import javax.swing.JOptionPane;

import Exceptions.DadosPessoaisIncompletosException;
import Exceptions.RendimentoInvalidoException;

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
		Boolean isValid = true;
		
		do {

			try {
				nome = JOptionPane.showInputDialog(null,"Informe o nome da pessoa:");
				verificarNome(this.nome, "Informe um nome válido.");
				isValid = true;
			} catch (DadosPessoaisIncompletosException e) {
				isValid = false;
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		} while (!isValid);
		
		do {

			try {
				email = JOptionPane.showInputDialog("Informe o email da pessoa:");
				verificarEmail(this.email, "Informe um email válido.");
				isValid = true;
			} catch (DadosPessoaisIncompletosException e) {
				isValid = false;
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		} while (!isValid);
		
		do {

			try {
				totRendimento = JOptionPane.showInputDialog("Informe o rendimento total da pessoa ");
				verificarRendimento(this.totRendimento, "Informe um rendimento válido.");
				isValid = true;
			} catch (DadosPessoaisIncompletosException e) {
				isValid = false;
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		} while (!isValid);		
	
		do {

			try {
				totRendimento = JOptionPane.showInputDialog("Informe o rendimento total da pessoa ");
				Rendimento = Float.parseFloat(totRendimento);
				 verificarRendimentoInvalido(Rendimento, "Informe um rendimento válido");
				isValid = true;
			} catch (RendimentoInvalidoException e) {
				isValid = false;
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		} while (!isValid);
		
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
	
	public void verificarNome(String nome, String mensagem) throws DadosPessoaisIncompletosException {
		if (nome.isBlank()) {
			throw new DadosPessoaisIncompletosException(mensagem);
		}
	}
	public void verificarEmail(String email, String mensagem) throws DadosPessoaisIncompletosException {
		if (email.isBlank()) {
			throw new DadosPessoaisIncompletosException(mensagem);
		}
	}
	public void verificarRendimento(String totRendimento, String mensagem) throws DadosPessoaisIncompletosException {
		if (totRendimento.isBlank()) {
			throw new DadosPessoaisIncompletosException(mensagem);
		}
	}
	public void verificarRendimentoInvalido(float Rendimento, String mensagem) throws RendimentoInvalidoException {
		if (Rendimento < 0) {
			throw new RendimentoInvalidoException(mensagem);
		}
	}
}
