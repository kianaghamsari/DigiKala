package Shop;

import java.util.ArrayList;
import java.util.UUID;

import Account_Types.Account;
import Account_Types.Admin;
import Account_Types.Seller;
import Account_Types.User;
import Product.Product;

public class Shop {

    private String name;
    private String webAddress;
    private String supportPhoneNumber;
    private ArrayList<Product> products;
    private ArrayList<Account> accounts;
    private Account currentAccount;


    public Shop() {

    }

    public Shop(String name, String webAddress, String supportPhoneNumber) {
        this.name = name;
        this.webAddress = webAddress;
        this.supportPhoneNumber = supportPhoneNumber;
        this.products = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.currentAccount = null;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWebAddress() {
        return webAddress;
    }
    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getSupportPhoneNumber() {
        return supportPhoneNumber;
    }
    public void setSupportPhoneNumber(String supportPhoneNumber) {
        this.supportPhoneNumber = supportPhoneNumber;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }
    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Account getAccount(UUID id) {
        for (Account account: this.accounts) {
            if (account.getAccID() == (id))
                return account;
        }
        return null;
    }

    public Account getAccount(String username) {
        for (Account account: this.accounts) {
            if (account.getUsername().equalsIgnoreCase(username))
                return account;
        }
        return null;
    }

    public boolean doesAccountExist(String username) {
        for (Account account : this.accounts) {
            if (account.doesAccountExist(username)) {
                return true;
            }
        }
        return false;
    }

    public void adminSignUp(String username, String password, String emailAddress) {
        if (this.doesAccountExist(username))
            System.out.println("Account already exists.");
        else {
            Admin newAdmin = new Admin(username, password, emailAddress);
            this.accounts.add(newAdmin);
        }

    }

    public void sellerSignUp(String companyName, String password) {
        if (this.doesAccountExist(companyName)) {
            System.out.println("Account already exists.");
        } else {
            Seller newSeller = new Seller(companyName, password);
            this.accounts.add(newSeller);
        }
    }

    public void userSignUp(String username, String password, String emailAddress, String phoneNumber, String address) {
        if (this.doesAccountExist(username)) {
            System.out.println("Account already exists.");
        } else {
            User newUser = new User(username, password, emailAddress, phoneNumber, address, 0);
            this.accounts.add(newUser);
        }
    }

    public boolean adminLogin(String username, String password) {
        for (Account account : this.accounts) {
            if (account instanceof Admin) {
                if (account.accountLogin(username, password)) {
                    this.setCurrentAccount(account);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sellerLogin(String companyName, String password) {
        for (Account account : this.accounts) {
            if (account instanceof Seller) {
                if (account.accountLogin(companyName, password)) {
                    this.setCurrentAccount(account);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean userLogin(String username, String password) {
        for (Account account : this.accounts) {
            if (account instanceof User) {
                if (account.accountLogin(username, password)) {
                    this.setCurrentAccount(account);
                    return true;
                }
            }
        }
        return false;
    }

    public void addTheProductToShop(Product product) {
        this.products.add(product);
        System.out.println("Product has been added successfully.\n");
    }

    public ArrayList<Product> searchProductsByName(String name) {
        ArrayList<Product> searchedProduct = new ArrayList<>();
        for (Product product: products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                searchedProduct.add(product);
            }
        }
        return searchedProduct;
    }

    public ArrayList<Product> searchProductsByCategory(String category) {
        ArrayList<Product> searchedProduct = new ArrayList<>();
        for (Product product: products) {
            if (product.getCategory().toLowerCase().contains(category.toLowerCase())) {
                searchedProduct.add(product);
            }
        }
        return searchedProduct;
    }

    public void logOut() {
        if (this.currentAccount == null) {
            System.out.println("Can't logout.");
        } else {
            this.currentAccount = null;
            System.out.println("Logged out.");
        }
    }

}
