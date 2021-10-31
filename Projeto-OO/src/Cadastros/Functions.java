package Cadastros;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Functions {
    public static void gravarArquivo(String nomeDoArquivo, String fileText) {
        BufferedWriter buffer = null;
        FileWriter out = null;

        try {
            out = new FileWriter(nomeDoArquivo, true);
            buffer = new BufferedWriter(out);

            buffer.write(fileText);
            buffer.write('\n');

            buffer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha durante a gravação do arquivo.");
        }
    }
    public static String lerArquivo(String nomeDoArquivo) {
        try {
            BufferedReader myBuffer = new BufferedReader(
                    new InputStreamReader(new FileInputStream(nomeDoArquivo), "UTF-8"));

            String linha = myBuffer.readLine();

            String categorias = "";
            while (linha != null) {
                categorias = categorias + linha + "\n";
                linha = myBuffer.readLine();
            }

            myBuffer.close();
            return categorias;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha durante a leitura do arquivo.");
            return "";
        }

    }
    
}
