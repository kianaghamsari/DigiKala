package Product.Categories.Digital_Device;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Connect;
import Product.Product;
import Product.Categories.Categories.DigitalDevice;
import Shop.Shop;

public class Phone extends Product implements DigitalDevice {

    private int cameraQuality;
    private int ram;
    private double screenSize;
    private int storage;

    public Phone() {

    }

    public Phone(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            int cameraQuality, int ram, double screenSize, int storage) {
        super(productID, name, price, quantity, comments, category);
        this.cameraQuality = cameraQuality;
        this.ram = ram;
        this.screenSize = screenSize;
        this.storage = storage;
    }


    public int getCameraQuality() {
        return cameraQuality;
    }
    public void setCameraQuality(int cameraQuality) {
        this.cameraQuality = cameraQuality;
    }

    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getStorage() {
        return storage;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return
        "\nCamera Quality of the product: " + this.getCameraQuality() +
        "\nRam of the product: " + this.getRam() +
        "\nScreen Size of the product: " + this.getScreenSize() +
        "\nStorage of the product: " + this.getStorage() +
        super.toString();

    }

    public static void phoneData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Phone");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                int screenQuality = rs.getInt("camera_quality");
                int ram = rs.getInt("ram");
                double screenSize = rs.getDouble("screen_size");
                int storage = rs.getInt("_storage");

                Phone newPhone = new Phone(productID, name, price, quantity, new ArrayList<String> (), category, screenQuality, ram, screenSize, storage);
                shop.addTheProductToShop(newPhone);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
