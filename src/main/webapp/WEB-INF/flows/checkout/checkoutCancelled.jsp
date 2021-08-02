<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <section>
        <div class="jumbotron pt-xxl-4">
            <div class="container">
                <h1 class="alert-danger">Checkout Cancelled</h1>

                <p>Your checkout process is cancelled.</p>
            </div>
        </div>
    </section>

    <section class="container">
        <p><a href="<spring:url value="/product/productList"/>"
              class="btn btn-primary">Products</a></p>
    </section>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>