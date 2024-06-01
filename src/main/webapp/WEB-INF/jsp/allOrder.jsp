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
                <div>
                    <table id="datatables-example" class="table table-striped table-bordered" width="100%"
                        cellspacing="0">
                        <thead>
                            <tr>
                                <th>訂單編號</th>
                                <th>會員編號</th>
                                <th>訂單金額</th>
                                <th>付款狀態</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="order" items="${orders}">
                                <tr>
                                    <td>${order.orderId}</td>
                                    <td>${order.memberId}</td>
                                    <td>${order.price}</td>
                                    <c:if test="${order.payStatus}">
                                        <td>已支付</td>
                                    </c:if>
                                    <c:if test="${!order.payStatus}">
                                        <td>未支付</td>
                                    </c:if>
                                </tr>
                                <c:forEach var="detail" items="${order.orderDetails}">
                                    <tr>
                                        <td colspan="4">
                                            <table class="table table-bordered details-table">
                                                <thead>
                                                    <tr>
                                                        <th>商品編號</th>
                                                        <th>數量</th>
                                                        <th>單價</th>
                                                        <th>單品項總價</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="detail" items="${order.orderDetails}">
                                                        <tr>
                                                            <td>${detail.product.productId}</td>
                                                            <td>${detail.quantity}</td>
                                                            <td>${detail.standPrice}</td>
                                                            <td>${detail.itemPrice}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </body>

        </html>