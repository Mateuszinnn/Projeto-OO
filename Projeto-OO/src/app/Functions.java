package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

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
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha durante a grava��o do arquivo.");
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
            JOptionPane.showMessageDialog(null, "Op��o inv�lida! Tente novamente.");
            return false;
        } else {
            return true;
        }

    }

    public static int pegarMes() {
        String mes;
        Boolean isValid = false;
        do {
            mes = JOptionPane.showInputDialog(
                    "Escolha o mês da despesa:\n1) Janeiro\n2) Fevereiro \n3) Março \n4) Abril\n5) Maio \n6) Junho \n7) Julho\n8) Agosto \n9) Setembro \n10) Outubro\n11) Novembro\n12) Dezembro");

            if (isInteger(mes, "O mês selecionado é inválido, tente novamente.")) {
                isValid = true;
                if (Integer.parseInt(mes) < 1 || Integer.parseInt(mes) > 12) {
                    isValid = false;
                }
            }
        } while (!isValid);

        return Integer.parseInt(mes);
    }

    public static int pegarAno() {
        String ano;
        Boolean isValid = false;
        Calendar cal = Calendar.getInstance();
        do {
            ano = JOptionPane.showInputDialog("Escolha o ano da despesa");

            if (isInteger(ano, "O ano digitado é inválido, tente novamente.")) {
                isValid = true;
                if (Integer.parseInt(ano) < cal.get(Calendar.YEAR) || Integer.parseInt(ano) > 2050) {
                    isValid = false;
                }
            }
        } while (!isValid);

        return Integer.parseInt(ano);
    }

}