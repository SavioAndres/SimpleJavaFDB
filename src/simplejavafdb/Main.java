package simplejavafdb;

/**
 *
 * @author Sávio Andres
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleJavaFDB db = new SimpleJavaFDB("database");
        db.insert("teste");
    }
    
}
