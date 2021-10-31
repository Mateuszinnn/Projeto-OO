package Cadastros;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


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
}
