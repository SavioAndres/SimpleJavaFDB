package simplejavafdb;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 *
 * @author Sávio Andres
 */
public class Insert {

    private String path;
    private Select select;

    protected Insert(String path) {
        this.path = path;
        select = new Select(path);
    }

    protected int insert(String data) {
        try (FileWriter arq = new FileWriter(this.path, true)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            int ultimuId = select.ultimoId();
            gravarArq.write(ultimuId + 1 + "->" + data + "\r\n");
            return ultimuId + 1;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        return -1;
    }

    protected void insertDatabase(TreeMap<Integer, String> data) {
        data.values().forEach((value) -> {
            insert(value);
        });
    }

}
