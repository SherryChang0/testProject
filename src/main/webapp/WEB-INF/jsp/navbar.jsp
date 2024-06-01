<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>test project</title>
      <link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />
    </head>

    <body>
      <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="${contextRoot}/">首頁</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  商品
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="${contextRoot}/add">新增商品</a></li>
                  <li><a class="dropdown-item" href="${contextRoot}/allProduct">顯示商品</a></li>
                </ul>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  訂單
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="${contextRoot}/addOrder">新增訂單</a></li>
                  <li><a class="dropdown-item" href="${contextRoot}/allOrder">訂單內容</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
      <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
    </body>

    </html>