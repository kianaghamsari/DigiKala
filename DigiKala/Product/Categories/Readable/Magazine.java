package Product.Categories.Readable;

import java.util.ArrayList;
import Shop.Shop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Connect;

// import Product.Categories.Categories.Readable;

public class Magazine extends Book /* implements Readable */ {

    public Magazine() {

    }

    public Magazine(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            String author, int yearOfPublish) {
        super(productID, name, price, quantity, comments, category, author, yearOfPublish);

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void bookData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Magazine");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                String author = rs.getString("author");
                int yearOfPublish = rs.getInt("year_of_publish");

                Magazine newMagazine = new Magazine(productID, name, price, quantity, new ArrayList<String> (), category, author, yearOfPublish);
                shop.addTheProductToShop(newMagazine);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
