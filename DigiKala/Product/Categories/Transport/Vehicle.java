package Product.Categories.Transport;

import java.util.ArrayList;

import Product.Product;
import Product.Categories.Categories.Transport;

public class Vehicle extends Product implements Transport {

    private int speed;
    private String color;


    public Vehicle() {

    }

    public Vehicle(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            int speed, String color) {
        super(productID, name, price, quantity, comments, category);
        this.speed = speed;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return
        "\nThe Speed of the Product: " + this.getSpeed() +
        "\nThe Color of the Product: " + this.getColor() +
        super.toString();
    }
    
}
