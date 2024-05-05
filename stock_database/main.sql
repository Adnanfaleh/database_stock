create database stock_db;

CREATE TABLE customers_table
( customer_id int NOT NULL,
  name varchar(20) NOT NULL,
  surname varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  address varchar(25) NOT NULL,
);

CREATE TABLE categories_table
( category_id int NOT NULL,
  category_name varchar(25) NOT NULL,
);

CREATE TABLE products_table
( product_id int NOT NULL,
  product_name varchar(250) NOT NULL,
  product_category varchar(20) FOREIGN KEY references categories_table(category_name) NOT NULL,
  price int NOT NULL,
  availability varchar(20) NOT NULL,
);

