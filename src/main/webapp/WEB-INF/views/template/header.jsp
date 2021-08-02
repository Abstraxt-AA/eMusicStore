<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: abstraxt
  Date: 7/17/21
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author"
          content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>My Music Store</title>

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="canonical"
          href="https://getbootstrap.com/docs/5.0/examples/carousel/">

    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>"
          rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">My Music Store</a>
            <button class="navbar-toggler" type="button"
                    data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/"/>">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"
                           href="<c:url value="/product/productList"/>">Products</a>
                    </li>
                    <%--                    <li class="nav-item">--%>
                    <%--                        <a class="nav-link" href="<c:url value="/admin"/>">Admin</a>--%>
                    <%--                    </li>--%>
                </ul>
                <ul class="navbar-nav me-2 mb-2 mb-md-0 float-end">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link">Welcome: ${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link"
                               href="<c:url value="/j_spring_security_logout"/>">Logout</a>
                        </li>
                        <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="<c:url value="/customer/cart"/>">Cart</a>
                            </li>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="<c:url value="/admin"/>">Admin</a>
                            </li>
                        </c:if>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item">
                        <a class="nav-link"
                           href="<c:url value="/login"/>">Login</a>
                    </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register"/>">Register</a>
                    </li>
                </ul>
                <%--                <form class="d-flex me-2 mb-2 mb-md-0">--%>
                <%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
                <%--                    <button class="btn btn-outline-success" type="submit">Search</button>--%>
                <%--                </form>--%>
            </div>
        </div>
    </nav>
</header>
