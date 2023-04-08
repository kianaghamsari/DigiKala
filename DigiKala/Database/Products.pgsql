CREATE TABLE Product (
    Product_id UUID NOT NULL PRIMARY KEY,
    Name_of_Product VARCHAR(100) NOT NULL,
    Price NUMERIC(19,2) NOT NULL CHECK (Price > 0),
    Quantity INTEGER,
    Category VARCHAR(100)
);

CREATE TABLE Laptop (
    Screen_Quality VARCHAR(100) NOT NULL,
    Ram INTEGER NOT NULL,
    Does_Have_Camera BOOLEAN NOT NULL
) INHERITS (Product);

CREATE TABLE Phone (
    Camera_Quality INTEGER NOT NULL,
    Ram INTEGER NOT NULL,
    Screen_Size NUMERIC NOT NULL,
    _Storage INTEGER NOT NULL
) INHERITS (Product);

CREATE TABLE Watch (
    Processor VARCHAR(100) NOT NULL,
    Does_Have_Heartbeat_Sensor BOOLEAN NOT NULL
) INHERITS (Product);

CREATE TABLE Candy_And_Chocolate (
    Taste VARCHAR(50) NOT NULL
) INHERITS (Product);

CREATE TABLE Fruit (
    Package_Type VARCHAR(50) NOT NULL
) INHERITS (Product);

CREATE TABLE Book (
    Author VARCHAR(100) NOT NULL,
    Year_Of_Publish INTEGER NOT NULL
) INHERITS (Product);

CREATE TABLE EBook (
    Is_Paid_EBook BOOLEAN NOT NULL
) INHERITS (Book);

CREATE TABLE Magazine (
) INHERITS (Book);

CREATE TABLE Vehicle (
    Speed INTEGER NOT NULL,
    Color VARCHAR(50) NOT NULL
) INHERITS (Product);

CREATE TABLE Car (
    Is_Gearbox_Type_Automatic BOOLEAN NOT NULL
) INHERITS (Vehicle);

CREATE TABLE Motorcycle (
    Does_Have_Cargo_Space BOOLEAN NOT NULL
) INHERITS (Vehicle);


-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Laptop (Product_id, Name_of_Product, Price, Quantity, Category, Screen_Quality, Ram, Does_Have_Camera)
VALUES (UUID_GENERATE_V4(), 'MacBook Air', 1000, 5, 'Digital_Device', '1920 x 1080', 8, true);

INSERT INTO Laptop (Product_id, Name_of_Product, Price, Quantity, Category, Screen_Quality, Ram, Does_Have_Camera)
VALUES (UUID_GENERATE_V4(), 'Gaming Laptop', 1500, 2, 'Digital_Device', '1920 x 1080', 16, false);
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Phone (Product_id, Name_of_Product, Price, Quantity, Category, Camera_Quality, Ram, Screen_Size, _Storage)
VALUES (UUID_GENERATE_V4(), 'Samsung Galaxy S9+', 800, 5, 'Digital_Device', 15, 8, 5.8, 128);

INSERT INTO Phone (Product_id, Name_of_Product, Price, Quantity, Category, Camera_Quality, Ram, Screen_Size, _Storage)
VALUES (UUID_GENERATE_V4(), 'Iphone XI', 700, 2, 'Digital_Device', 12, 4, 5.2, 64);
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Watch (Product_id, Name_of_Product, Price, Quantity, Category, Processor, Does_Have_Heartbeat_Sensor)
VALUES (UUID_GENERATE_V4(), 'Apple Watch', 900, 3, 'Digital_Device', 'S8 SiP with 64-bit dual-core processor', true);

INSERT INTO Watch (Product_id, Name_of_Product, Price, Quantity, Category, Processor, Does_Have_Heartbeat_Sensor)
VALUES (UUID_GENERATE_V4(), 'Watch', 700, 4, 'Digital_Device', 'S8 SiP with 64-bit dual-core processor', false);
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Candy_And_Chocolate (Product_id, Name_of_Product, Price, Quantity, Category, Taste)
VALUES (UUID_GENERATE_V4(), 'Nutella', 10, 10, 'Edible', 'Sweetened hazelnut cocoa spread');
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Fruit (Product_id, Name_of_Product, Price, Quantity, Category, Package_Type)
VALUES (UUID_GENERATE_V4(), 'Apple', 1, 20, 'Edible', 'Plastic bags');
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Book (Product_id, Name_of_Product, Price, Quantity, Category, Author, Year_Of_Publish)
VALUES (UUID_GENERATE_V4(), 'Game of Thrones: A Song of Ice and Fire', 15, 10, 'Readable', 'George R.R. Martin', 1996);
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO EBook (Product_id, Name_of_Product, Price, Quantity, Category, Author, Year_Of_Publish, Is_Paid_EBook)
VALUES (UUID_GENERATE_V4(), 'Game of Thrones: A Song of Ice and Fire', 10, 1, 'Readable', 'George R.R. Martin', 1996, true);
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Magazine (Product_id, Name_of_Product, Price, Quantity, Category, Author, Year_Of_Publish)
VALUES (UUID_GENERATE_V4(), 'Do It Yourself', 10, 10, 'Readable', 'Kindle', 2023);
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Car (Product_id, Name_of_Product, Price, Quantity, Category, Speed, Color, Is_Gearbox_Type_Automatic)
VALUES (UUID_GENERATE_V4(), '2024 Audi RS7', 126000, 10, 'Transport', 200, 'Ascari Blue', true);
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Motorcycle (Product_id, Name_of_Product, Price, Quantity, Category, Speed, Color, Does_Have_Cargo_Space)
VALUES (UUID_GENERATE_V4(), 'Motorcycle', 10000, 10, 'Transport', 150, 'Black', false);
-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------