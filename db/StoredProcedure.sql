CREATE PROCEDURE AddProduct
    @p_id VARCHAR(10),
    @p_name VARCHAR(100),
    @p_price INT,
    @p_quantity INT
AS
BEGIN
    INSERT INTO Product (productID, productName, price, quantity) 
    VALUES (@p_id, @p_name, @p_price, @p_quantity);
END;

