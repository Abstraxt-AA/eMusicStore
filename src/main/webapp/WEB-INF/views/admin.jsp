<%@ include file="template/header.jsp" %>

<main>

    <div class="container">
        <div class="accordion-header pt-xxl-4">
            <h1>Administrator Page</h1>
            <p class="lead">This is the administrator page.</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout"/>">
                Logout</a>
            </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory"/>">Product Inventory</a>
        </h3>

        <p>Here you can view, check, and modify the product inventory.</p>

        <br><br>

        <h3>
            <a href="<c:url value="/admin/customer"/>">Customer Management</a>
        </h3>

        <p>Here you can view the customer information.</p>

<%@include file="template/footer.jsp" %>