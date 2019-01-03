package simplejavafdb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 *
 * @author Sávio Andres
 */
public class Select {

    private String path;

    protected Select(String path) {
        this.path = path;
    }

    protected TreeMap<Integer, String> readLines() {
        TreeMap<Integer, String> dados = new TreeMap<>();
        String a, b = null;
        try {
            FileInputStream stream = new FileInputStream(this.path);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);
            String linha = br.readLine();
            while (linha != null) {
                a = linha.split("->")[0];
                b = linha.split("->")[1];
                dados.put(Integer.parseInt(a), b);
                linha = br.readLine();
            }
            return dados;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
    
    protected int ultimoId() {
        TreeMap<Integer, String> list = new TreeMap<>();
        list = readLines();
        if(list.isEmpty()) {
            return -1;
        } else {
            return list.lastKey();
        }
    }
    
    protected boolean containsId(int id) {
        TreeMap<Integer, String> list = new TreeMap<>();
        list = readLines();
        return list.containsKey(id);
    }
    
}
