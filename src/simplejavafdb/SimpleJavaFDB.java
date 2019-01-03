package simplejavafdb;

import java.util.TreeMap;

/**
 *
 * @author Sávio Andres
 */
public class SimpleJavaFDB {
    private Insert insert;
    private Select select;
    private Update update;
    private Delete delete;
    
    public SimpleJavaFDB(String database) {
        this("src/base/", database);
    }

    public SimpleJavaFDB(String path, String database) {
        String path_ = path + database + ".jfdb";
        this.insert = new Insert(path_);
        this.select = new Select(path_);
        this.update = new Update(path_);
        this.delete = new Delete(path_);
    }
    
    
    
    public int insert(String data) { 
        return insert.insert(data);
    }
    
    public void insertDatabase(TreeMap<Integer, String> data) {
        insert.insertDatabase(data);
    }
    
    public int Update(int id, String data) {
        return update.insertUp(id, data);
    }
    
    public TreeMap<Integer, String> select() {
        return this.select.readLines();
    }
    
    public int lastId() {
        return select.ultimoId();
    }
    
    public boolean containsId(int id) {
        return select.containsId(id);
    }
    
    public void deleteDatabase() {
        delete.deleteDatabase();
    }
    
    public TreeMap<Integer, String> volatileBackup() {
        return delete.volatileBackup();
    }
    
}
