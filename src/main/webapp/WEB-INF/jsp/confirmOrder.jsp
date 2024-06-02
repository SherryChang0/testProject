<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <jsp:include page="navbar.jsp" />
        <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
        <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html>

        <head>
            <style>
                .container {
                    width: 100%;
                    margin: 0 auto;
                }

                table {
                    width: 100%;
                    margin-bottom: 20px;
                }

                input[type="submit"] {
                    background-color: #007bff;
                    color: white;
                    border: none;
                    cursor: pointer;
                    padding: 10px 20px;
                    margin-top: 20px;
                }
            </style>
            <script>
                function buy(){
                    
                }
            </script>
        </head>

        <body>
            <div class="container">
                <h2>訂單確認</h2>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>商品編號</th>
                            <th>商品名稱</th>
                            <th>單價</th>
                            <th>數量</th>
                            <th>單品項總價</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detail" items="${orderDetail}">
                            <tr>
                                <td>${detail.product.productId}</td>
                                <td>${detail.product.productName}</td>
                                <td>${detail.product.price}</td>
                                <td>${detail.quantity}</td>
                                <td>${detail.itemPrice}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="4" style="font-weight: 700;">總金額</td>
                            <td>${totalAmount}</td>
                        </tr>
                    </tbody>
                </table>
                <form id="orderForm" action="${contextRoot}/confirmOrder" method="post" onsubmit="buy()">
                    <input type="submit" value="確認訂單">
                </form>
            </div>
        </body>

        </html>