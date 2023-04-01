package manager;

import model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVManager {

    private static final String productsPath = "../data/products.csv";

    public static Product[] readAllProducts() {
        try {
            return Files.lines(Path.of(productsPath))
                    .map(line -> line.split(","))
                    .map(Product::fromCsv)
                    .toArray(Product[]::new);
        } catch (IOException e) {
            System.out.println("Unable to read from file" + productsPath);
            return new Product[]{};
        }
    }

}
