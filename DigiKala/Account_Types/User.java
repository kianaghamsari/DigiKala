// import Account_Types;

package Account_Types;
import Product.*;
import Shop.Shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class User extends Account {

    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private Map<Product, Integer> Cart = new HashMap<>();
    private ArrayList<ArrayList<Product>> orderHistory;
    private ArrayList<Product> purchasedProducts;
    private double wallet;

    public User() {

    }

    public User(String username, String password, String emailAddress, String phoneNumber, String address, double wallet) {

        super(username, password);
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.wallet = 10;
        this.Cart = new HashMap<>();
        this.orderHistory = new ArrayList<>();
        this.purchasedProducts = new ArrayList<>();

    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Map<Product, Integer> getCart() {
        return Cart;
    }

    public void setCart(Map<Product, Integer> Cart) {
        this.Cart = Cart;
    }

    public ArrayList<ArrayList<Product>> getOrderHistory() {
        return orderHistory;
    }
    public void setOrderHistory(ArrayList<ArrayList<Product>> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }
    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public double getWallet() {
        return wallet;
    }
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void updateEmailAddress(String newEmailAddress){
        if (newEmailAddress.equals(this.emailAddress)){
            System.out.println("Nothing Changed.");
        } else {
            setEmailAddress(newEmailAddress);
            System.out.println("Changed.");
        }
    }

    public void updatePhoneNumber(String newPhoneNumber){
        if (newPhoneNumber.equals(this.phoneNumber)){
            System.out.println("Nothing Changed.");
        } else {
            setPhoneNumber(newPhoneNumber);
            System.out.println("Changed.");
        }
    }

    public void updateAddress(String newAddress){
        if (newAddress.equals(this.address)){
            System.out.println("Nothing Changed.");
        } else {
            setAddress(newAddress);
            System.out.println("Changed.");
        }
    }

    @Override
    public String toString() {
        return "\nThe information of the user \"" + this.getUsername() +
        super.toString() +
        "\nCart: " + this.getCart() +
        "\nOrders History: " + this.getOrderHistory() +
        "\nPurchased Products: " + this.getPurchasedProducts() +
        "\nEmail Address: " + this.getEmailAddress() +
        "\nPhone Number: " + this.getPhoneNumber() +
        "\nAddress: " + this.getAddress() +
        "\nWallet: " + this.wallet;
    }

    public void addToCart(Shop shop,Product product, int quantity){
        this.Cart.put(product, quantity);
    }

    public void removeFromCart(Shop shop,Product product){
        this.Cart.remove(product);
    }

    @Override
    public boolean accountLogin(String username, String password) {
        return this.username.equalsIgnoreCase(username) && this.password.equals(password);
    }

    public void viewCart() {
        System.out.println(this.getCart());
        System.out.println("Total Price: ");
        System.out.println(calculateTotalPrice(this.Cart));
    }

    public void viewOrderHistory() {
        System.out.println(this.getOrderHistory());
    }

    public void viewPurchasedProducts() {
        // for (Product product: this.getPurchasedProducts())
            System.out.println(this.getPurchasedProducts());
    }

    public void viewWallet() {
        System.out.println(this.getWallet());
    }

    public boolean doesAccountExist(String username) {
        return this.username.equalsIgnoreCase(username);
    }

    public void pay(double value) {
        this.wallet -= value;
    }

    public double calculateTotalPrice(Map<Product, Integer> cart) {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }

    public void order() {
        orderHistory.add(new ArrayList<>(Cart.keySet()));
    }

    public void purchase() {
        purchasedProducts.addAll(new ArrayList<>(Cart.keySet()));
    }

}