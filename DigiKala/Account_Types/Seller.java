package Account_Types;
import java.util.ArrayList;
import Product.*;

public class Seller extends Account {
    private String companyName;
    private ArrayList<Product> availableProducts;
    private double wallet;
    private boolean isAuthorized;

    public Seller() {

    }

    public Seller(String companyName, String password) {
        super(companyName, password);
        this.availableProducts = new ArrayList<>();
        this.wallet = 10;
        this.isAuthorized = false;

    }

    @Override
    public String getUsername() {
        return this.companyName;
    }

    @Override
    public void setUsername(String companyName) {
        this.companyName = companyName;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    @Override
    public String toString() {
        return
        "\nIs Authorized? " + (this.isAuthorized ? "Yes":"No") +
        "\nCompany Name: " + this.companyName +
        "\nPassword: " + this.getPassword() +
        "\nAvailable Products: " + this.availableProducts +
        "\n Wallet: " + this.wallet;
    }

    public boolean accountLogin(String username, String password) {
        return this.companyName.equalsIgnoreCase(username) && this.getPassword().equals(password);
    }

    @Override
    public boolean doesAccountExist(String username) {
        return this.companyName.equalsIgnoreCase(username);
    }

    public void viewAvailableProducts() {
        System.out.println(this.availableProducts);
    }

    public void viewWallet() {
        System.out.println(wallet);
    }

    public void addToProducts(Product product) {
        this.availableProducts.add(product);
    }

    public void removeProduct(Product product) {
        if (this.availableProducts.contains(product))
            this.availableProducts.remove(product);
    }

    public void removeProduct(String id) {
        for (Product product: this.availableProducts) {
            if (product.getProductID().equalsIgnoreCase(id)) {
                this.availableProducts.remove(product);
            }
        }
    }


}
