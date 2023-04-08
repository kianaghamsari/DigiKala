# DigiKala Report

![](https://github.com/kianaghamsari/Second-Assignment/blob/develop/uni.png)

## Kiana Ghamsari - 400222079


# Introduction

This program is a simple version of "Digikala" which will allow users signup and login to their account and have some functionalities within the shop. The project is intended to demonstrate the use of object-oriented programming concepts and database connectivity in Java. The system will consist of several classes and interfaces, each responsible for a specific set of tasks. These will include classes for managing products, categories and shopping. The project also involves a database for easy management of data.

# Objective

The main objective of this project is to create a shop management system that can handle the basic operations required in a shop, including adding/removing items to cart, viewing cart and total price, order history on the user end and adding items to the shop, along with administration capabilities for the admins, being able to manage accounts and products.

Products in different categories are shown with their own defined specifics, for example an item such as car has the characteristic of speed while a digital device like phone must have camera quality. some general specs (e.g., quantity) also must be available for each item, getting updated with access to database.

# Design and Implementation

* `Product` class has been created to manage the products in the shop. The `Product` class includes methods for loading and updating products.
* Proper usage of UUID has been included in order to make certain entities identifiable.
* While each product, has specifics and identifier, price, category and …, it might have implemented a subcategory interface and inherited the parent class.
* Users either identifying as `Admin`, `User` or `Seller` are able to sign up, log in and log out. related functions are all defined in the `Shop` class.
* Users are able to update their account information such as Email address, phone number and address. Adding shop items to cart in desired quantity is also available to users.
* The user can remove items from the cart and view them along with order history. Viewing the wallet, adding order and knowing the total price using ` calculateTotalPrice()` is also available to the user.
* The user is able to search for products using different functions, namely `searchProductsByName()` and ` searchProductsByCategory()` which are defined in `Shop` class, gathering name, address and support phone number.
* In the `Main` class, the account is down casted either to seller or user where ever needed, for instance:

     `Seller currSeller = (Seller) shop.getCurrentAccount();`
* Some initial data is defined using PostgreSQL
*The shop is connected to a database to allow for easy data storage and retrieval.
* Each product class is supplied with a function to retrieve data from the database, creating a new object from its class.
* The details of the classes are shown in this UML diagram:

   [UML](https://lucid.app/lucidchart/08d76616-2181-4c33-81df-2a40e49c6356/edit?viewport_loc=-410%2C-2697%2C18934%2C9091%2C1YLM5Gasw73m&invitationId=inv_01e247fc-3dc0-42f7-b931-a4e99b681f27)
* Some screenshots from several created tables in PostgreSQL are provided: 

![image_2023-04-08_22-12-18](https://user-images.githubusercontent.com/90266554/230738925-3eac8b21-0383-422f-ab8d-9cf423628a8e.png)
![image_2023-04-08_22-14-00](https://user-images.githubusercontent.com/90266554/230738934-f5e2465a-4f2d-478e-99bb-0ac9d26f0993.png)

# conclusion

in this project I experienced:

*  Working with abstract methods and interfaces.
*  Using SQL and PostgreSQL.
*  Using UUID to uniquely identify entities in both PostgreSQL and Java.
*  Use of object-oriented programming concepts.
*  Database connectivity and data management.
