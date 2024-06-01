<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
            <jsp:include page="navbar.jsp"></jsp:include>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>新增訂單</title>
                <link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />
                <style>
                    form {
                        width: 70%;
                        padding: 20px;
                        border: 1px solid #ccc;
                        border-radius: 5px;
                        margin: 20px auto;
                    }

                    table {
                        width: 100%;
                        margin-bottom: 20px;
                    }

                    th,
                    td {
                        padding: 10px;
                        text-align: left;
                        border-bottom: 1px solid #ddd;
                    }

                    th {
                        background-color: #f2f2f2;
                    }

                    input[type="number"] {
                        width: 100px;
                    }

                    input[type="submit"] {
                        background-color: #007bff;
                        color: white;
                        border: none;
                        cursor: pointer;
                        padding: 10px 20px;
                        margin-top: 20px;
                    }

                    input[type="submit"]:hover {
                        background-color: #0056b3;
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
                            var isValid = true;
                            $("input[type='number']").each(function () {
                                var max = $(this).attr("max");
                                var val = $(this).val();
                                if (val > max) {
                                    isValid = false;
                                    alert("購買數量不能大於庫存量！");
                                    return false; 
                                }
                            });
                            if (!isValid) {
                                event.preventDefault();
                            }
                        });
                    });
                </script>
            </head>

            <body>
                <div class="container">
                    <h2>新增訂單</h2>
                    <form action="${contextRoot}/addOrder" method="post">
                        <table>
                            <thead>
                                <tr>
                                    <th>選擇</th>
                                    <th>商品編號</th>
                                    <th>商品名稱</th>
                                    <th>售價</th>
                                    <th>庫存</th>
                                    <th>購買數量</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="product" items="${products}">
                                    <c:if test="${product.quantity > 0}">
                                        <tr>
                                            <td><input type="checkbox" name="productId" value="${product.productId}">
                                            </td>
                                            <td>${product.productId}</td>
                                            <td>${product.productName}</td>
                                            <td>${product.price}</td>
                                            <td>${product.quantity}</td>
                                            <td><input type="number" name="quantity_${product.productId}" min="1"
                                                    max="${product.quantity}" value="1"></td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                        <input type="submit" value="提交訂單">
                    </form>
                </div>
            </body>

            </html>