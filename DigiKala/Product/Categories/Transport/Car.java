package Product.Categories.Transport;

import java.util.ArrayList;
import Shop.Shop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Connect;

// import Product.Categories.Categories.Transport;

public class Car extends Vehicle /* implements Transport */ {

    private boolean isGearboxTypeAutomatic;


    public Car() {

    }
    
    public Car(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            int speed, String color, boolean isGearboxTypeAutomatic) {
        super(productID, name, price, quantity, comments, category, speed, color);
        this.isGearboxTypeAutomatic = isGearboxTypeAutomatic;
    }


    public boolean isGearboxTypeAutomatic() {
        return isGearboxTypeAutomatic;
    }
    public void setGearboxTypeAutomatic(boolean isGearboxTypeAutomatic) {
        this.isGearboxTypeAutomatic = isGearboxTypeAutomatic;
    }


    @Override
    public String toString() {
        return
        "\nIs Gearbox Type of the Product Automatic? " + (this.isGearboxTypeAutomatic() ? "Yes" : "No") +
        super.toString();
    }

    public static void carData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Car");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                int speed = rs.getInt("speed");
                String color = rs.getString("color");
                Boolean isGearboxTypeAutomatic = rs.getBoolean("is_gearbox_type_automatic");

                Car newCar = new Car(productID, name, price, quantity, new ArrayList<String> (), category, speed, color, isGearboxTypeAutomatic);
                shop.addTheProductToShop(newCar);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
