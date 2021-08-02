<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <section>
        <div class="jumbotron pt-xxl-4">
            <div class="container">
                <h1>Thank you for your business!</h1>

                <p>Your order will be shipped in two business days!</p>
            </div>
        </div>
    </section>

    <section class="container">
        <p><a href="<spring:url value="/"/>"
              class="btn btn-primary">OK</a></p>
    </section>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>