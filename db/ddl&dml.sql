--Product
CREATE TABLE Product (
productID VARCHAR(10) PRIMARY KEY,
productName VARCHAR(100) NOT NULL,
price INT NOT NULL,
quantity INT NOT NULL
);

INSERT INTO Product (productID, productName, price, quantity) VALUES
('P001', 'osii 舒壓按摩椅', 98000, 5),
('P002', '網友最愛起司蛋糕', 1200, 50),
('P003', '真愛密碼項鍊', 8500, 20);

-- Order
CREATE TABLE Orders (
orderId VARCHAR(50) PRIMARY KEY,
memberId VARCHAR(10) NOT NULL,
price INT NOT NULL,
payStatus TINYINT NOT NULL
);

INSERT INTO Orders (orderId, memberId, price, payStatus) VALUES
('Ms20250801186230', 458, 98000, 1),
('Ms20250805157824', 55688, 9700, 0),
('Ms20250805258200', 1713, 2400, 1);

-- OrderDetail
CREATE TABLE OrderDetail (
orderItemSN INT PRIMARY KEY,
orderID VARCHAR(50) NOT NULL,
productID VARCHAR(10) NOT NULL,
quantity INT NOT NULL,
standPrice INT NOT NULL,
itemPrice INT NOT NULL,
FOREIGN KEY (orderId) REFERENCES Orders(orderId),
FOREIGN KEY (productID) REFERENCES Product(productID)
);

INSERT INTO OrderDetail (orderItemSN, orderID, productID, quantity, standPrice, itemPrice) VALUES
(1, 'Ms20250801186230', 'P001', 1, 98000, 98000),
(2, 'Ms20250805157824', 'P002', 1, 1200, 1200),
(3, 'Ms20250805157824', 'P003', 1, 8500, 8500),
(4, 'Ms20250805258200', 'P002', 2, 1200, 2400);

SELECT * FROM Product;
SELECT * FROM Orders;
SELECT * FROM OrderDetail;