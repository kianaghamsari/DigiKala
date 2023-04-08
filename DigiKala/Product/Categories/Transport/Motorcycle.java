package Product.Categories.Transport;

import java.util.ArrayList;
import Shop.Shop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Connect;

// import Product.Categories.Categories.Transport;

public class Motorcycle extends Vehicle /* implements Transport */ {

    private boolean doesHaveCargoSpace;

    public Motorcycle() {

    }

    public Motorcycle(String productID, String name, double price, int quantity, ArrayList<String> comments,
            String category, int speed, String color, boolean doesHaveCargoSpace) {
        super(productID, name, price, quantity, comments, category, speed, color);
        this.doesHaveCargoSpace = doesHaveCargoSpace;
    }

    public boolean isDoesHaveCargoSpace() {
        return doesHaveCargoSpace;
    }
    public void setDoesHaveCargoSpace(boolean doesHaveCargoSpace) {
        this.doesHaveCargoSpace = doesHaveCargoSpace;
    }

    @Override
    public String toString() {
        return
        "\nDoes the Product Have Cargo Space? " + (this.isDoesHaveCargoSpace() ? "Yes" : "No") +
        super.toString();

    }

    public static void motorcycleData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Motorcycle");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                int speed = rs.getInt("speed");
                String color = rs.getString("color");
                Boolean doesHaveCargoSpace = rs.getBoolean("does_have_cargo_space");

                Motorcycle newMotorcycle = new Motorcycle(productID, name, price, quantity, new ArrayList<String> (), category, speed, color, doesHaveCargoSpace);
                shop.addTheProductToShop(newMotorcycle);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
