<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="template/header.jsp" %>

<main>

    <div class="container">
        <div class="accordion-header pt-xxl-4">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page.</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                    style="width: 100%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD</td>
                    <td>
                        <a href="<spring:url value="/product/viewProduct/${product.productId}"/>"><span class="pe-3 bi bi-info-circle-fill"></span></a>
                        <a href="<spring:url value="/admin/product/deleteProduct/${product.productId}"/>"><span class="pe-3 bi bi-x-octagon-fill"></span></a>
                        <a href="<spring:url value="/admin/product/editProduct/${product.productId}"/>"><span class="bi bi-pencil-square"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/product/addProduct"/>" class="btn btn-primary">Add Product</a>

<%@include file="template/footer.jsp" %>