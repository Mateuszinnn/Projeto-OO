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

    public static boolean isInteger(String string, String mensagem) {
        if (string.isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, mensagem);
            return false;
        }

        return true;
    }

    public static boolean isDouble(String string) {
        if (string.isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean rangeOfValues(int min, int max, int option) {

        if (option < min || option > max) {
            JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            return false;
        } else {
            return true;
        }

    }

}
