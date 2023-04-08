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

public class Watch extends Product implements DigitalDevice {

    private String processor;
    private boolean doesHaveHeartbeatSensor;


    public Watch() {

    }

    public Watch(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            String processor, boolean doesHaveHeartbeatSensor) {
        super(productID, name, price, quantity, comments, category);
        this.processor = processor;
        this.doesHaveHeartbeatSensor = doesHaveHeartbeatSensor;
    }

    
    public String getProcessor() {
        return processor;
    }
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public boolean isDoesHaveHeartbeatSensor() {
        return doesHaveHeartbeatSensor;
    }
    public void setDoesHaveHeartbeatSensor(boolean doesHaveHeartBeatSensor) {
        this.doesHaveHeartbeatSensor = doesHaveHeartBeatSensor;
    }

    @Override
    public String toString() {
        return 
        "\nProcessor of the product: " + this.getProcessor() +
        "\nDoes the Product Have Heartbeat Sensor? " + (this.isDoesHaveHeartbeatSensor() ? "Yes":"No") +
        super.toString();

    }

    public static void watchData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Watch");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                String processor = rs.getString("processor");
                boolean doesHaveHeartbeatSensor = rs.getBoolean("does_have_heartbeat_sensor");

                Watch newWatch = new Watch(productID, name, price, quantity, new ArrayList<String> (), category, processor, doesHaveHeartbeatSensor);
                shop.addTheProductToShop(newWatch);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
