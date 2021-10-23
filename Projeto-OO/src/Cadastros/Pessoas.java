package cadastros;

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
	private float totRendimento;
	public int numPessoas;
	private float Rendimento;
	
	List<Pessoas> pessoa;
	
	String nomeArquivo = "alunos.txt";

	public Pessoas(String nomePessoa, String emailPessoa, float totRend) {
		this.nome = nomePessoa;
		this.email = emailPessoa;
		this.totRendimento = totRend;
		this.numPessoas = 0;
	}

	public Pessoas() {
		pessoa = new LinkedList<Pessoas>();
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
		nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
		email = JOptionPane.showInputDialog("Informe o email da pessoa:");
		Rendimento = Float.parseFloat(JOptionPane.showInputDialog("Informe o rendimento total da pessoa "));
		totRendimento= Rendimento + totRendimento;
		numPessoas = numPessoas+1;
		
		Pessoas p = new Pessoas(nome,email,totRendimento);
		
		boolean resposta = pessoa.add(p);
		if (resposta) 
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
		return;
	}
	public String toString() {
		return "<" + nome + ">;<" + email + ">;<" + totRendimento + ">;";
	}
	public void gravarAlunos() {
		BufferedWriter buffer = null;
		FileWriter out = null;
		
		try {
			out = new FileWriter(nomeArquivo);
			buffer = new BufferedWriter(out);
			
			for (Pessoas p : pessoa) {
				buffer.write(p.toString());
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
				Pessoas p = new Pessoas(str[0], str[1], str[2]);
				pessoa.add(p);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
