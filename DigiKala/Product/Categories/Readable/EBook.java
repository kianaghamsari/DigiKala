package Product.Categories.Readable;

import java.util.ArrayList;
import Shop.Shop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Connect;

// import Product.Categories.Categories.Readable;

public class EBook extends Book /* implements Readable */ {

    private boolean isPaidEBook;


    public EBook() {

    }

    public EBook(String productID, String name, double price, int quantity, ArrayList<String> comments, String category,
            String author, int yearOfPublish, boolean isPaidEBook) {
        super(productID, name, price, quantity, comments, category, author, yearOfPublish);
        this.isPaidEBook = isPaidEBook;
    }

    public boolean getIsPaidEBook() {
        return isPaidEBook;
    }
    public void setIsPaidEBook(boolean isPaidEBook) {
        this.isPaidEBook = isPaidEBook;
    }

    @Override
    public String toString() {
        return
        "\nIs the Product a Paid Book? " + (this.getIsPaidEBook() ? "Yes":"No") +
        super.toString();

    }

    public static void EBookData(Shop shop) {
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EBook");
            // Shop shop = new Shop();

            while(rs.next()) {
                String productID = rs.getString("product_id");
                String name = rs.getString("name_of_product");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                String author = rs.getString("author");
                int yearOfPublish = rs.getInt("year_of_publish");
                boolean isPaidEBook = rs.getBoolean("is_paid_ebook");

                EBook newEBook = new EBook(productID, name, price, quantity, new ArrayList<String> (), category, author, yearOfPublish, isPaidEBook);
                shop.addTheProductToShop(newEBook);
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
