<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <jsp:include page="navbar.jsp"></jsp:include>
        <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
        <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html>

        <head>
            <style>
                form {
                    width: 50%;
                    padding: 50px;
                    border: 1px solid #ccc;
                    border-radius: 5px;
                    margin: 0 auto;
                }

                input[type="text"],
                input[type="submit"] {
                    width: 100%;
                    padding: 10px;
                    margin-bottom: 10px;
                }

                input[type="submit"] {
                    background-color: #007bff;
                    color: white;
                    border: none;
                    cursor: pointer;
                }

                input[type="submit"]:hover {
                    background-color: #0056b3;
                }

                .message {
                    margin-top: 20px;
                    font-weight: bold;
                }

                .container {
                    width: 100%;
                    margin: 0 auto;
                    text-align: center;
                }
            </style>
            <script>
                $(document).ready(function () {
                    $("form").submit(function (event) {
                        event.preventDefault();

                        var productId = $("#productId").val().trim();
                        var productName = $("#productName").val().trim();
                        var price = $("#price").val().trim();
                        var quantity = $("#quantity").val().trim();

                        if (productId == "" || productName == "" || price == "" || quantity == "") {
                            alert("請填寫所有欄位！");
                            return false;
                        }

                        $.ajax({
                            type: "POST",
                            url: "${contextRoot}/addProduct",
                            data: $("form").serialize(),
                            success: function (response) {
                                alert(response);
                            }
                        });
                    });
                });
            </script>

        </head>

        <body>
            <div class="container">
                <h2>新增商品</h2>
                <form action="${contextRoot}/addProduct" method="post" modelAttribute="product"
                    enctype="multipart/form-data">
                    <label for="productId">商品編號:</label>
                    <input type="text" id="productId" name="productId"><br><br>
                    <label for="productName">商品名稱:</label>
                    <input type="text" id="productName" name="productName"><br><br>
                    <label for="price">售價:</label>
                    <input type="text" id="price" name="price"><br><br>
                    <label for="stock">庫存:</label>
                    <input type="text" id="quantity" name="quantity"><br><br>
                    <input type="submit">
                </form>
            </div>
        </body>

        </html>