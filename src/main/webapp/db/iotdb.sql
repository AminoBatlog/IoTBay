CREATE TABLE Customer_Management (
  Cust_ID numeric(6) NOT NULL,
  Staff_ID numeric(6) NOT NULL,
  CONSTRAINT CustMan_PK PRIMARY KEY (Cust_ID, Staff_ID),
  CONSTRAINT CustMan_FK1 FOREIGN KEY (Cust_ID) REFERENCES Customer(Cust_ID),
  CONSTRAINT CustMan_FK2 FOREIGN KEY (Staff_ID) REFERENCES Staff(Staff_ID)
);
CREATE TABLE Device_Management (
  Staff_ID numeric(6) NOT NULL,
  Dev_ID numeric(6) NOT NULL,
  CONSTRAINT DevMan_PK PRIMARY KEY (Staff_ID, Dev_ID),
  CONSTRAINT DevMan_FK1 FOREIGN KEY (Staff_ID) REFERENCES Staff(Staff_ID),
  CONSTRAINT DevMan_FK2 FOREIGN KEY (Dev_ID) REFERENCES IOT_Dev(Dev_ID)
);
CREATE TABLE Staff (
  Staff_ID numeric(6) NOT NULL,
  Staff_FName varchar(25),
  Staff_LName varchar(25),
  Email varchar(320) NOT NULL,
  Password varchar(256) NOT NULL,
  DOB date,
  Staff_streetNo numeric(10),
  Staff_streetName varchar(100),
  Staff_city varchar(100),
  Staff_zipcode numeric(10),
  Staff_country varchar(30),
  Roles varchar(50),
  CONSTRAINT Staff_PK PRIMARY KEY (Staff_ID)
);
CREATE TABLE Credit_card (
  Payment_ID numeric(6) NOT NULL,
  Credit_cardNo numeric(16) NOT NULL,
  Card_type numeric(3),
  Expired_date date,
  CONSTRAINT Card_PK PRIMARY KEY (Payment_ID),
  CONSTRAINT Card_FK FOREIGN KEY (Payment_ID) REFERENCES Payment(Payment_ID)
);
CREATE TABLE Orderline (
  Order_ID numeric(6) NOT NULL,
  Dev_ID numeric(6) NOT NULL,
  Order_quantity numeric(10),
  CONSTRAINT Orderline_PK PRIMARY KEY (Order_ID, Dev_ID),
  CONSTRAINT Orderline_FK1 FOREIGN KEY (Order_ID) REFERENCES Orders(Order_ID),
  CONSTRAINT Orderline_FK2 FOREIGN KEY (Dev_ID) REFERENCES IOT_Dev(Dev_ID)
);
CREATE TABLE Product_Category (
  Dev_ID numeric(6) NOT NULL,
  Cat_ID numeric(6) NOT NULL,
  CONSTRAINT ProdCat_PK PRIMARY KEY (Dev_ID, Cat_ID),
  CONSTRAINT ProdCat_FK1 FOREIGN KEY (Dev_ID) REFERENCES IOT_Dev(Dev_ID),
  CONSTRAINT ProdCat_FK2 FOREIGN KEY (Cat_ID) REFERENCES Category(Cat_ID)
);
CREATE TABLE IOT_Dev (
  Dev_ID numeric(6) NOT NULL AUTO_INCREMENT,
  Dev_Name varchar(30),
  Dev_price double,
  Quantity numeric(10),
  CONSTRAINT IOTDev_PK PRIMARY KEY (Dev_ID)
);
CREATE TABLE Checks (
  Payment_ID numeric(6) NOT NULL,
  Bank_ID varchar(11),
  Payee_name varchar(100),
  CONSTRAINT Check_PK PRIMARY KEY (Payment_ID),
  CONSTRAINT Check_FK FOREIGN KEY (Payment_ID) REFERENCES Payment(Payment_ID)
);
CREATE TABLE Payment (
  Payment_ID numeric(6) NOT NULL AUTO_INCREMENT,
  Cust_ID numeric(6) NOT NULL,
  Payment_method varchar(10),
  Payment_date date,
  Delivery_time time,
  CONSTRAINT Pay_PK PRIMARY KEY (Payment_ID),
  CONSTRAINT Pay_FK FOREIGN KEY (Cust_ID) REFERENCES Customer(Cust_ID)
);
CREATE TABLE Orders (
  Order_ID numeric(6) NOT NULL,
  Cust_ID numeric(6) NOT NULL,
  Order_status varchar(30),
  Delivery_date date,
  Delivery_time time,
  CONSTRAINT Order_PK PRIMARY KEY (Order_ID),
  CONSTRAINT Order_FK FOREIGN KEY (Cust_ID) REFERENCES Customer(Cust_ID)
);
CREATE TABLE Category (
  Cat_ID numeric(6) NOT NULL AUTO_INCREMENT,
  Cat_Name varchar(100),
  Sub_Cat numeric(6),
  CONSTRAINT Cat_PK PRIMARY KEY (Cat_ID),
  CONSTRAINT Cat_FK FOREIGN KEY (Sub_Cat) REFERENCES Category(Cat_ID)
);
CREATE TABLE Customer (
  Cust_ID numeric(6) NOT NULL,
  Cust_FName varchar(25),
  Cust_LName varchar(25),
  Email varchar(320) NOT NULL,
  Password varchar(256) NOT NULL,
  DOB date,
  Cust_streetNo numeric(10),
  Cust_streetName varchar(100),
  Cust_city varchar(100),
  Cust_zipcode numeric(10),
  Cust_country varchar(30),
  CONSTRAINT Cust_PK PRIMARY KEY (Cust_ID)
);
