-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pushsprce
-- ------------------------------------------------------
-- Server version	5.7.19

-- 商品表（Product）
CREATE TABLE Product (
  ProductID INT PRIMARY KEY,
  Name VARCHAR(255),
  Description VARCHAR(255),
  Price DECIMAL(10, 2),
  Stock INT,
  SoldQuantity INT
);
-- ------------------------------------------------------
-- 用户表（user）
CREATE TABLE User (
  UserID INT PRIMARY KEY,
  Username VARCHAR(50),
  Password VARCHAR(50),
  Email VARCHAR(100),
  Address VARCHAR(255)
);
-- ------------------------------------------------------
-- 订单表（Orders）
CREATE TABLE Orders (
  OrderID INT PRIMARY KEY,
  UserID INT,
  Status VARCHAR(50),
  CreateTime TIMESTAMP,
  FOREIGN KEY (UserID) REFERENCES User(UserID),
  FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);
-- CREATE TABLE `orders` (
--   `OrderID` int NOT NULL,
--   `UserID` int DEFAULT NULL,
--   `Status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
--   `CreateTime` time DEFAULT NULL,
--   PRIMARY KEY (`OrderID`),
--   KEY `UserID` (`UserID`),
--   CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- ------------------------------------------------------
-- 秒杀活动表（SeckillActivity）
CREATE TABLE SeckillActivity (
  ActivityID INT PRIMARY KEY,
  ProductID INT,
  StartTime DATETIME,
  EndTime DATETIME,
  Status VARCHAR(50),
  FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);
-- ------------------------------------------------------
-- 秒杀记录表（SeckillRecord）
CREATE TABLE SeckillRecord (
  RecordID INT PRIMARY KEY,
  UserID INT,
  ActivityID INT,
  ProductID INT,
  SeckillTime DATETIME,
  FOREIGN KEY (UserID) REFERENCES User(UserID),
  FOREIGN KEY (ActivityID) REFERENCES SeckillActivity(ActivityID),
  FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);
-- ------------------------------------------------------

INSERT INTO Product (ProductID, Name, Description, Price, Stock, SoldQuantity)
VALUES
  (1, 'iPhone 12', 'Apple iPhone 12', 999, 50, 10),
  (2, 'Galaxy S21', 'Samsung Galaxy S21', 899, 30, 5);
-- ------------------------------------------------------
INSERT INTO User (UserID, Username, Password, Email, Address)
VALUES
  (101, 'Alice', 'pass123', 'alice@example.com', '123 Main St, City A'),
  (102, 'Bob', 'password1', 'bob@example.com', '456 Elm St, City B'),
  (103, 'Charlie', '12345678', 'charlie@example.com', '789 Oak St, City C');
  -- ------------------------------------------------------
INSERT INTO SeckillActivity (ActivityID, ProductID, StartTime, EndTime, Status)
VALUES
  (1, 1, '2024-01-05 09:00:00', '2024-01-05 10:00:00', 'In progress'),
  (2, 2, '2024-01-05 10:30:00', '2024-01-05 11:30:00', 'Completed');
    -- ------------------------------------------------------
    INSERT INTO SeckillRecord (RecordID, UserID, ActivityID, ProductID, SeckillTime)
VALUES
  (1, 101, 1, 1, '2024-01-05 09:15:00'),
  (2, 102, 2, 2, '2024-01-05 11:00:00');
      -- ------------------------------------------------------
      INSERT INTO Orders (OrderID, UserID, ProductID, Quantity, Status, CreateTime)
VALUES
  (1, 101, 1, 2, 'In progress', '2024-01-05 10:00:00'),
  (2, 102, 2, 1, 'Completed', '2024-01-05 11:30:00');