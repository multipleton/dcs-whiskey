package manager;

import model.Product;

import java.sql.*;
import java.util.Arrays;

public class DBManager {

    private final String url = "jdbc:postgresql://localhost/dcs";
    private final String user = "dcs-user";
    private final String password = "dcs-password";

    private Connection connection;

    private static DBManager instance;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
            instance.init();
        }
        return instance;
    }

    private DBManager() {
    }

    private void init() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkIsEmpty() {
        String sql = "SELECT * FROM products";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return !resultSet.next();
        } catch (SQLException e) {
            System.out.println("Unable to check is table empty");
        }
        return false;
    }

    public boolean createAll(Product[] products) {
        String sql = "INSERT INTO products (name, department, description, price, image, released_at) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for (Product product: products) {
                statement.setString(1, product.getName());
                statement.setString(2, product.getDepartment());
                statement.setString(3, product.getDescription());
                statement.setDouble(4, product.getPrice());
                statement.setString(5, product.getImage());
                statement.setString(6, product.getReleasedAt());
                statement.addBatch();
                statement.clearParameters();
            }
            return Arrays.stream(statement.executeBatch()).allMatch(entry -> entry == 1);
        } catch (SQLException e) {
            System.out.println("Unable to insert data");
        }
        return false;
    }

    public void find() {
        String sql = "SELECT (name, department, description, price, image, released_at) FROM products";

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Unable to fetch data");
        }
    }

    public void update() {
        String sql = "UPDATE products SET price = price * 38";

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Unable to update data");
        }
    }

}
