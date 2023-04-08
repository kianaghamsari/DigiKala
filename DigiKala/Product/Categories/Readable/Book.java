package Product.Categories.Readable;

import java.util.ArrayList;

import Product.Product;
import Product.Categories.Categories.Readable;
import Shop.Shop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Connect;

public class Book extends Product implements Readable {

    private String author;
    private int yearOfPublish;


    public Book() {

    }
    
    public Book(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            String author, int yearOfPublish) {
        super(productID, name, price, quantity, comments, category);
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }


    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }
    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }


    @Override
    public String toString() {
        return
        "\nAuthor of the Product: " + this.getAuthor() +
        "\nPublish Year of the Product: " + this.getYearOfPublish() +
        super.toString();

    }

    public static void bookData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                String author = rs.getString("author");
                int yearOfPublish = rs.getInt("year_of_publish");

                Book newBook = new Book(productID, name, price, quantity, new ArrayList<String> (), category, author, yearOfPublish);
                shop.addTheProductToShop(newBook);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
