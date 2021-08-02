<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="template/header.jsp" %>

<div class="container">
    <section>
        <div class="jumbotron pt-xxl-4">
            <div class="container">
                <h1>Customer registered successfully.</h1>
            </div>
        </div>
    </section>

    <section class="container">
        <p><a href="<spring:url value="/product/productList"/>"
              class="btn btn-primary">Products</a></p>
    </section>
</div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="template/footer.jsp" %>