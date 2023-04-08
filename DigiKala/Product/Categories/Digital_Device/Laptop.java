package Product.Categories.Digital_Device;

import Product.Product;
import Product.Categories.Categories.DigitalDevice;

import Shop.Shop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Connect;

public class Laptop extends Product implements DigitalDevice {

    private String screenQuality;
    private int ram;
    private boolean doesHaveCamera;

    public Laptop() {

    }

    public Laptop(String productID, String name, double price, int quantity, ArrayList<String> comments, String category, String screenQuality, int ram, boolean doesHaveCamera) {
        super(productID, name, price, quantity, comments, category);
        this.screenQuality = screenQuality;
        this.ram = ram;
        this.doesHaveCamera = doesHaveCamera;

    }

    public String getScreenQuality() {
        return screenQuality;
    }
    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }

    public boolean isDoesHaveCamera() {
        return doesHaveCamera;
    }
    public void setDoesHaveCamera(boolean doesHaveCamera) {
        this.doesHaveCamera = doesHaveCamera;
    }

    @Override
    public String toString() {
        return
        "\nScreen Quality of the product: " + this.getScreenQuality() +
        "\nRam of the product: " + this.getRam() +
        "\nDoes the Product Have Camera? " + (this.isDoesHaveCamera() ? "Yes":"No") +
        super.toString();

    }

    public static void laptopData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Laptop");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                String screenQuality = rs.getString("screen_quality");
                int ram = rs.getInt("ram");
                boolean doesHaveCamera = rs.getBoolean("does_have_camera");

                Laptop newLaptop = new Laptop(productID, name, price, quantity, new ArrayList<String> (), category, screenQuality, ram, doesHaveCamera);
                shop.addTheProductToShop(newLaptop);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
