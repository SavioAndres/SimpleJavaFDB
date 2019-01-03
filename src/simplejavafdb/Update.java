package simplejavafdb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Sávio Andres
 */
public class Update {

    private String path;
    private Select select;
    
    protected Update(String path) {
        this.path = path;
        select = new Select(path);
    }

    protected int insertUp(int id, String data) {
        int idNovo = select.ultimoId() + 1;
        String a, b = null;
        try {
            FileInputStream stream = new FileInputStream(this.path);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);

            FileWriter arq = new FileWriter(this.path, true);
                PrintWriter gravarArq = new PrintWriter(arq);

                String linha = br.readLine();
                while (linha != null) {
                    a = linha.split("->")[0];
                    b = linha.split("->")[1];
                    if (a.contains(id + "")) {
                        String linha2 = linha.replace(linha, idNovo + "->" + b + ", " + data);
                        gravarArq.write(linha2 + "\r\n");
                        gravarArq.close();
                        arq.close();
                        return idNovo;
                    }
                    linha = br.readLine();
                }
            
        } catch (IOException e) {
            System.out.println(e);
        }
        return -1;
    }

}
