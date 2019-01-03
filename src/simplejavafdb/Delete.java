package simplejavafdb;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 *
 * @author Sávio Andres
 */
public class Delete {
    private String path;
    private Select select;
    private TreeMap<Integer, String> database;

    protected Delete(String path) {
        this.path = path;
        this.select = new Select(path);
        this.database = new TreeMap<>();
        
    }
    
    protected void deleteDatabase() {
        this.database = select.readLines();
        try (FileWriter arq = new FileWriter(this.path)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.write("");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    
    protected TreeMap<Integer, String> volatileBackup() {
        return database;
    }
    
}
