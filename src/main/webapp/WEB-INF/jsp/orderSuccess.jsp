<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Order Success</title>
        <style>
            .container {
                margin: 0 auto;
                text-align: center;
                padding: 50px;
                border: 1px solid #ccc;
                border-radius: 5px;
                width: 50%;
            }

            h1 {
                color: #4CAF50;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <h1>Order Success</h1>
            <p>Your order has been successfully placed.</p>
            <a href="<c:url value='/products'/>">Continue Shopping</a>
        </div>
    </body>

    </html>