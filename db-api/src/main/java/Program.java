import manager.CSVManager;
import manager.DBManager;
import manager.FileManager;
import model.Product;
import util.Timer;

public class Program {
    public static void main(String... args) {
        Product[] products = CSVManager.readAllProducts();
        DBManager dbManager = DBManager.getInstance();
        if (dbManager.checkIsEmpty()) {
            if (DBManager.getInstance().createAll(products)) {
                System.out.println("Products successfully inserted");
            }
        }
        System.out.println("Starting test");
        Timer timer = new Timer();
        timer.start();

        dbManager.find();
        dbManager.update();

        double ms = timer.end();
        String result = "Finished in " + ms + " ms";
        System.out.println(result);
        FileManager.writeResult(result);
    }
}
