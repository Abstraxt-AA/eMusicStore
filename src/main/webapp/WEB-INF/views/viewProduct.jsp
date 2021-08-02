<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="template/header.jsp" %>

<main>

    <div class="container">
        <div class="accordion-header pt-xxl-4">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detailed information of the product!</p>
        </div>

        <div class="container" ng-app = "cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                         style="width: 100%"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p><strong>Description:</strong> ${product.productDescription}</p>
                    <p><strong>Manufacturer:</strong> ${product.productManufacturer}</p>
                    <p><strong>Category:</strong> ${product.productCategory}</p>
                    <p><strong>Condition:</strong> ${product.productCondition}</p>
                    <h4>${product.productPrice} USD</h4>

                    <br>

                    <c:set var="role" scope="page" value="${pageContext.request.userPrincipal.name}"/>
                    <c:set var="url" scope="page" value="/product/productList"/>
                    <c:if test="${role eq 'admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>
                    <p ng-controller="cartCtrl">
                        <a href="#" class="btn btn-warning" ng-click="addToCart('${product.productId}')">
                            <span class="bi bi-cart pe-1"></span>Order Now</a>
                        <a href="<spring:url value="/customer/cart"/>" class="btn btn-primary">
                            <span class="bi bi-cart-check-fill pe-1"></span> View Cart</a>
                        <a href="<c:url value="${url}"/>" class="btn btn-secondary">Back</a>
                    </p>


                </div>
            </div>
        </div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="template/footer.jsp" %>