import manager.CSVManager;
import manager.DBManager;
import model.Product;

public class Program {
    public static void main(String... args) {
        Product[] products = CSVManager.readAllProducts();
        DBManager dbManager = DBManager.getInstance();
        if (dbManager.checkIsEmpty()) {
            if (DBManager.getInstance().createAll(products)) {
                System.out.println("Products successfully inserted");
            }
        }
    }
}
