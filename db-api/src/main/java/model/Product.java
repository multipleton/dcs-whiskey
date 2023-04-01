package model;

public class Product {
    private Integer id;
    private String name;
    private String department;
    private String description;
    private double price;
    private String image;
    private String releasedAt;

    public static Product fromCsv(String[] args) {
        String name = args[0];
        String department = args[1];
        String description = args[2];
        double price = Double.parseDouble(args[3]);
        String image = args[4];
        String releasedAt = args[5];
        return new Product(0, name, department, description, price, image, releasedAt);
    }

    public Product(Integer id, String name, String department, String description, double price, String image, String releasedAt) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.description = description;
        this.price = price;
        this.image = image;
        this.releasedAt = releasedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }
}
