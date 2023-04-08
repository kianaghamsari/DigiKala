package Product.Categories.Edible;

import java.util.ArrayList;

import Product.Product;
import Product.Categories.Categories.Edible;
import Shop.Shop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Connect;

public class Fruit extends Product implements Edible{

    private String packageType;

    public Fruit() {

    }

    public Fruit(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            String packageType) {
        super(productID, name, price, quantity, comments, category);
        this.packageType = packageType;
    }


    public String getPackageType() {
        return packageType;
    }
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    @Override
    public String toString() {
        return
        "\nPackage Type of the Product: " + this.getPackageType() +
        super.toString();
    }

    public static void fruitData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Fruit");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                String taste = rs.getString("taste");

                Fruit newFruit = new Fruit(productID, name, price, quantity, new ArrayList<String> (), category, taste);
                shop.addTheProductToShop(newFruit);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
