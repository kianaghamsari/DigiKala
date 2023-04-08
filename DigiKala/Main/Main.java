package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

// import Account_Types.Admin;
import Account_Types.Seller;
import Account_Types.User;
import Product.Categories.Digital_Device.Laptop;
import Product.Categories.Digital_Device.Phone;
import Product.Categories.Digital_Device.Watch;
import Product.Categories.Edible.CandyAndChocolate;
import Product.Categories.Edible.Fruit;
import Product.Categories.Readable.Book;
import Product.Categories.Readable.EBook;
import Product.Categories.Readable.Magazine;
import Product.Categories.Transport.Car;
import Product.Categories.Transport.Motorcycle;
import Shop.Shop;

public class Main {
    static Scanner input = new Scanner(System.in);
    private static Shop shop = new Shop("Shop", "www.DigiKala.ir","+989123456789");
    public static void main(String[] args) {
        shop.adminSignUp("admin", "admin", "admin@gmail.com");
        runMenu();
    }

    public static void runMenu() {
        System.out.println("Welcome to DIGIKALA. Please Choose: \n1: Sign Up as a new Seller\n2: Sign Up as a new User\n3: Login as a Seller\n4: Login as a User\n5: Login as an Admin");
        int chosenOption = input.nextInt();
        switch (chosenOption) {
            case 1: { //Sign up as a seller
                System.out.println("\nEnter Company Name: ");
                String companyName = input.next();
                System.out.println("Enter Password: ");
                String password = input.next();
                shop.sellerSignUp(companyName, password);
                runMenu();
                break;
            }
            case 2: { //Sign up as a user
                System.out.println("Please Enter :\n1: Username,\n2: Password,\n3: Email,\n4: Phone number,\n5: Address");
                String username = input.next();
                String password = input.next();
                String emailAddress = input.next();
                String phoneNumber = input.next();
                String address = input.next();
                shop.userSignUp(username, password, emailAddress, phoneNumber, address);
                runMenu();
                break;
            }
            case 3: { //Login as a seller
                System.out.println("Please Enter:\n1: Company name,\n2: Password");
                String companyName = input.next();
                String password = input.next();
                if (shop.sellerLogin(companyName, password)) {
                    sellerPage(shop);
                } else {
                    runMenu();
                }
                break;
            }
            case 4: { //Login as a user
                System.out.println("Please Enter:\n1: Username,\n2: Password");
                String username = input.next();
                String password = input.next();
                if (shop.userLogin(username, password)) {
                    userPage(shop);
                } else {
                    runMenu();
                }
                break;
            }
            case 5: { //Login as an admin
                System.out.println("Please Enter:\n1: Username,\n2: Password");
                String username = input.next();
                String password = input.next();
                if (shop.adminLogin(username, password)) {
                    adminPage(shop);
                } else {
                    runMenu();
                }
                break;
            }
            default: 
                runMenu();
                break;
        }
    }

    public static String userMenuPage() {
        return "1: Show and Search Products\n\tSearch By Name of Product\n\tSearch By Category\n2: View Your Cart\n3: View Your Wallet\n4: View Your Purchased Products\n5: Update Your Information\n\tUpdate Username\n\tUpdate Password\n\tUpdate Email Address\n\tUpdate Phone Number\n\tUpdate Address\n6: Add Comment\n7: Log out\n8: Add a Product to Cart\n9: Remove a Product from Cart\n10: Order Everything In Your Cart\n11: Purchase Everything In Your Cart";
    }

    public static String sellerMenuPage() {
        return "1: Add Product\n2: Remove Product\n3: Show All Products\n4: View Wallet\n5: Log Out";
    }

    public static String adminMenuPage() {
        return "1: Add Admin\n2: View All Users' Profile\n3: Log Out";
    }

    public static void userPage(Shop shop) {
        System.out.println("Welcome to your page \"" + shop.getCurrentAccount().getUsername() + "\"");
        System.out.println(userMenuPage());
        int chosenOption = input.nextInt();
        User currUser = (User) shop.getCurrentAccount();
        switch (chosenOption) {
            case 1: // 1: Show and Search Products
                System.out.println(shop.getProducts());
                System.out.println("1: Search By Name of Product\n2: Search By Category");
                int chosenOption2 = input.nextInt();
                switch (chosenOption2) {
                    case 1: // Search By Name of Product
                        System.out.println(shop.getProducts());
                        System.out.println("Enter name: ");
                        String name = input.next();
                        shop.searchProductsByName(name);
                        break;
                    case 2: // Search By Category
                        System.out.println(shop.getProducts());
                        System.out.println("Enter Category: ");
                        String category = input.next();
                        shop.searchProductsByCategory(category);
                        break;
                    default:
                        runMenu();
                        break;
                }
                break;

            case 2: // View Your Cart
                currUser.viewCart();
                break;

            case 3: // View Your Wallet
                currUser.viewWallet();

            case 4: // View Your Purchased Products
                currUser.viewPurchasedProducts();

            case 5: // Update Your Information
                System.out.println("1: Update Username\n2: Update Password\n3: Update Email Address\n4: Update Phone Number\n5: Update Address");
                int chosenOption5 = input.nextInt();
                switch (chosenOption5) {
                    case 1: // Update Username
                        System.out.println("Enter New Username: ");
                        String username = input.next();
                        currUser.editUserName(username);
                        break;

                    case 2: // Update Password
                        System.out.println("Enter New Password: ");
                        String password = input.next();
                        currUser.editPassword(password);
                        break;

                    case 3: // Update Email Address
                        System.out.println("Enter New Email Address: ");
                        String emailAddress = input.next();
                        currUser.updateEmailAddress(emailAddress);
                        break;

                    case 4: // Update Phone Number
                        System.out.println("Enter New Phone Number: ");
                        String phoneNumber = input.next();
                        currUser.updatePhoneNumber(phoneNumber);
                        break;

                    case 5: // Update Address
                        System.out.println("Enter New Address: ");
                        String address = input.next();
                        currUser.updateAddress(address);
                        break;

                    default:
                        runMenu();
                        break;

                }
            
            case 6: //  Add Comment
                System.out.println("Enter Product Name: ");
                String name = input.next();
                System.out.println("Enter Your Comment: ");
                String comment = input.next();
                shop.searchProductsByName(name).get(0).addComment(comment);
                break;

            case 7: // Log out
                shop.logOut();
                runMenu();
                break;

            case 8: // 8: Add a Product to Cart
                System.out.println("Enter Product Name: ");
                String name2 = input.next();
                System.out.println("Enter Quantity: ");
                int quantity = input.nextInt();
                currUser.addToCart(shop, shop.searchProductsByName(name2).get(0), quantity);
                break;

            case 9: // Remove a Product from Cart
                System.out.println("Enter Product Name: ");
                String name3 = input.next();
                currUser.removeFromCart(shop, shop.searchProductsByName(name3).get(0));
                break;

            case 10: //  Order Everything In Your Cart
                currUser.order();
                break;

            case 11: // Purchase Everything In Your Cart
                currUser.purchase();
                break;
        
            default:
                runMenu();
                break;
        }

    }

    public static void sellerPage(Shop shop) {
        System.out.println("Welcome to your page \"" + shop.getCurrentAccount().getUsername() + "\"");
        if (!((Seller) shop.getCurrentAccount()).isAuthorized()) {
            System.out.println("\n\tSeller has not been authorized.");
            runMenu();
        } else {
            Seller currSeller = (Seller) shop.getCurrentAccount();
            System.out.println(sellerMenuPage());
            System.out.println("Please Choose: ");
            int chosenOption = input.nextInt();
            switch (chosenOption) {
                case 1: // Add Product
                    System.out.println("Please Enter Type of the Product:\n1: Laptop\n2: Phone\n3: Watch\n4: Candy and Chocolate\n5: Fruit\n6: Book\n7: EBook\n8: Magazine\n9: Car\n10: Motorcycle");
                    int chosenOption2 = input.nextInt();
                    System.out.println("Enter name: ");
                    String name = input.next();
                    System.out.println("Enter Price: ");
                    double price = input.nextDouble();
                    System.out.println("Enter Quantity: ");
                    int quantity = input.nextInt();
                    switch (chosenOption2) {
                        case 1: // Laptop
                            System.out.println("Enter Screen Quality: ");
                            String screenQuality = input.next();
                            System.out.println("Enter Ram: ");
                            int laptopRam = input.nextInt();
                            System.out.println("Does It Have Camera? If Yes, Enter true: ");
                            boolean doesHaveCamera = input.nextBoolean();
                            Laptop newLaptop = new Laptop(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "DigitalDevice", screenQuality, laptopRam, doesHaveCamera);
                            currSeller.addToProducts(newLaptop);
                            break;
                        
                        case 2: // Phone
                            System.out.println("Enter Camera Quality: ");
                            int cameraQuality = input.nextInt();
                            System.out.println("Enter Ram: ");
                            int phoneRam = input.nextInt();
                            System.out.println("Enter Screen Size: ");
                            double screenSize = input.nextDouble();
                            System.out.println("Enter Storage: ");
                            int storage = input.nextInt();
                            Phone newPhone = new Phone(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "DigitalDevice", cameraQuality, phoneRam, screenSize, storage);
                            currSeller.addToProducts(newPhone);
                            break;
                        
                        case 3: // Watch
                            System.out.println("Enter Processor: ");
                            String processor = input.next();
                            System.out.println("Does It Have Heartbeat Sensor? If Yes Enter true: ");
                            boolean doesHaveHeartbeatSensor = input.nextBoolean();
                            Watch newWatch = new Watch(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "DigitalDevice", processor, doesHaveHeartbeatSensor);
                            currSeller.addToProducts(newWatch);
                            break;

                        case 4: // Candy and Chocolate
                            System.out.println("Enter the Taste: ");
                            String taste = input.next();
                            CandyAndChocolate newCandyAndChocolate = new CandyAndChocolate(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "Edible", taste);
                            currSeller.addToProducts(newCandyAndChocolate);
                            break;

                        case 5: // Fruit
                            System.out.println("Enter The Package Type: ");
                            String packageType = input.next();
                            Fruit newFruit = new Fruit(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "Edible", packageType);
                            currSeller.addToProducts(newFruit);
                            break;

                        case 6: // Book
                            System.out.println("Enter Author: ");
                            String author = input.next();
                            System.out.println("Enter Year of Publish: ");
                            int yearOfPublish = input.nextInt();
                            Book newBook = new Book(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "Readable", author, yearOfPublish);
                            currSeller.addToProducts(newBook);
                            break;

                        case 7: // EBook
                            System.out.println("Enter Author: ");
                            String E_author = input.next();
                            System.out.println("Enter Year of Publish: ");
                            int E_yearOfPublish = input.nextInt();
                            System.out.println("Is It Paid EBook? Enter true If Yes: ");
                            boolean isPaidEBook = input.nextBoolean();
                            EBook newEBook = new EBook(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "Readable", E_author, E_yearOfPublish, isPaidEBook);
                            currSeller.addToProducts(newEBook);
                            break;

                        case 8: // Magazine
                            System.out.println("Enter Author: ");
                            String M_author = input.next();
                            System.out.println("Enter Year of Publish: ");
                            int M_yearOfPublish = input.nextInt();
                            Magazine newMagazine = new Magazine(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "Readable", M_author, M_yearOfPublish);
                            currSeller.addToProducts(newMagazine);
                            break;

                        case 9: // Car
                            System.out.println("Enter the Speed: ");
                            int C_speed = input.nextInt();
                            System.out.println("Enter the Color: ");
                            String C_color = input.next();
                            System.out.println("Is It's Gearbox Type Automatic? Enter true If Yes: ");
                            boolean isGearboxTypeAutomatic = input.nextBoolean();
                            Car newCar = new Car(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "Transport", C_speed, C_color, isGearboxTypeAutomatic);
                            currSeller.addToProducts(newCar);
                            break;

                        case 10: // Mototrcycle
                            System.out.println("Enter the Speed: ");
                            int M_speed = input.nextInt();
                            System.out.println("Enter the Color: ");
                            String M_color = input.next();
                            System.out.println("Does It Have Cargo Space? Enter true If Yes: ");
                            boolean doesHaveCargoSpace = input.nextBoolean();
                            Motorcycle newMotorcycle = new Motorcycle(UUID.randomUUID().toString(), name, price, quantity, new ArrayList<String>(), "Transport", M_speed, M_color, doesHaveCargoSpace);
                            currSeller.addToProducts(newMotorcycle);
                            break;

                        default:
                            runMenu();
                            break;
                    }
                    break;

                case 2: // Remove Product
                    System.out.println("Enter The ID of The Product: ");
                    String id = input.next();
                    currSeller.removeProduct(id);
                    break;

                case 3: // Show All Products
                    currSeller.viewAvailableProducts();
                    break;

                case 4: // View Wallet
                    currSeller.viewWallet();
                    break;

                case 5: // Log Out
                    shop.logOut();
                    runMenu();
                    break;
            
                default:
                    runMenu();
                    break;
            }
        }
    }

    public static void adminPage(Shop shop) {
        System.out.println("Welcome to your page \"" + shop.getCurrentAccount().getUsername() + "\"");
        System.out.println(adminMenuPage());
        int chosenOption = input.nextInt();
        switch (chosenOption) {

            case 1: // Add Admin
                System.out.println("Enter Username: ");
                String username = input.next();
                System.out.println("Enter Password: ");
                String password = input.next();
                System.out.println("Enter Email Address: ");
                String emailAddress = input.next();
                shop.adminSignUp(username, password, emailAddress); 
                break;

            case 2: // View All Users' Profile
                System.out.println(shop.getAccounts());
                break;

            case 3: // Log Out
                shop.logOut();
                runMenu();
                break;

            default:
                runMenu();
                break;
        }
    }

}
