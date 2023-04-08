package Product.Categories.Edible;

import Product.Product;
import Product.Categories.Categories.Edible;
import java.util.ArrayList;
import Shop.Shop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Connect;

public class CandyAndChocolate extends Product implements Edible {
    
    private String taste;

    public CandyAndChocolate() {

    }

    public CandyAndChocolate(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            String taste) {
        super(productID, name, price, quantity, comments, category);
        this.taste = taste;
    }


    public String getTaste() {
        return taste;
    }
    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return
        "\nTaste of the Product: " + this.getTaste() +
        super.toString();
    }

    public static void candyAndChocolateData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Candy_And_Chocolate");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                String taste = rs.getString("taste");

                CandyAndChocolate newCandyAndChocolate = new CandyAndChocolate(productID, name, price, quantity, new ArrayList<String> (), category, taste);
                shop.addTheProductToShop(newCandyAndChocolate);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
