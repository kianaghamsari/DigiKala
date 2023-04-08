package Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Connect;
import Shop.Shop;

public class Product {
    
    private String productID;
    private String name;
    private double price;
    private int quantity;
    private ArrayList<String> comments;
    private String category;
    
    public Product() {
        
    }

    public Product(String productID, String name, double price, int quantity, ArrayList<String> comments, String category) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.comments = comments;
        this.category = category;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<String> getComments() {
        return comments;
    }
    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public void increaseQuantityOfProduct(int quantity) {
        this.quantity += quantity;
        updateTheProduct();
    }

    public void decreaseQuantityOfProduct(int quantity) {
        this.quantity -= quantity;
        updateTheProduct();
    }

    @Override
    public String toString() {
        return "\nThe information of the product \"" + this.getProductID() +
        "\":\nName of the product: " + this.getName() +
        "\nPrice of the product: " + this.getPrice() +
        "\nQuantity of the product: " + this.getQuantity() +
        "\nCategory: " + this.getCategory();
    }

    public static void productsData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");

                Product product = new Product(productID, name, price, quantity, new ArrayList<String> (), category);
                shop.addTheProductToShop(product);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTheProduct() {
        String sql = "UPDATE Products SET Quantity = ?, WHERE Product_id = ?";
        try {
            Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quantity);
            stmt.setString(2, productID.toString());
            stmt.executeUpdate();
            System.out.println("Product has been updated successfully.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

}
