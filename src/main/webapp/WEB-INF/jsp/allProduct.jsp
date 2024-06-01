<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <jsp:include page="navbar.jsp"></jsp:include>
        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html>

        <head>
            <style>
                .panel-body {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                }
            </style>
        </head>

        <body>
            <div class="panel-body">
                <div class="responsive-table">
                    <table id="datatables-example" class="table table-striped table-bordered" width="100%"
                        cellspacing="0">
                        <thead>
                            <tr>
                                <th>商品編號</th>
                                <th>商品名稱</th>
                                <th>售價</th>
                                <th>庫存</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${products}">
                                <c:if test="${product.quantity > 0}">
                                    <tr>
                                        <td>${product.productId}</td>
                                        <td>${product.productName}</td>
                                        <td>${product.price}</td>
                                        <td>${product.quantity}</td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </body>

        </html>