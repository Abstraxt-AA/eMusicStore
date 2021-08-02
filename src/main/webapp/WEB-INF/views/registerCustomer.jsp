<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="template/header.jsp" %>

<main>

    <div class="container">
        <div class="accordion-header pt-xxl-4">
            <h1>Register Customer</h1>

            <p class="lead">Please fill the below information.</p>
        </div>

        <form:form
                action="${pageContext.request.contextPath}/register"
                method="post" commandName="customer">
            <h3>Basic Info</h3>

            <div class="mb-3">
                <label for="name" class="fw-bold pe-1">Name</label><form:errors
                    path="customerName" cssStyle="color: #ff0000"/>
                <form:input path="customerName" id="name" class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="email" class="fw-bold pe-1">Email</label><form:errors
                    path="customerEmail" cssStyle="color: #ff0000"/><span
                    style="color: #ff0000">${emailMsg}</span>
                <form:input path="customerEmail" id="email"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="username" class="fw-bold pe-1">Username</label><form:errors
                    path="customerUsername" cssStyle="color: #ff0000"/><span
                    style="color: #ff0000">${usernameMsg}</span>
                <form:input path="customerUsername" id="username"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="password" class="fw-bold pe-1">Password</label><form:errors
                    path="customerPassword" cssStyle="color: #ff0000"/>
                <form:password path="customerPassword" id="password"
                               class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="phone" class="fw-bold">Phone</label>
                <form:input path="customerPhone" id="phone"
                            class="form-Control"/>
            </div>

            <h3>Billing Address</h3>

            <div class="mb-3">
                <label for="billingAddressStreetName" class="fw-bold">Street
                    Name</label>
                <form:input path="billingAddress.streetName"
                            id="billingAddressStreetName"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressApartmentNumber" class="fw-bold">Apartment
                    Number</label>
                <form:input path="billingAddress.apartmentNumber"
                            id="billingAddressApartmentNumber"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressCity" class="fw-bold">City</label>
                <form:input path="billingAddress.city" id="billingAddressCity"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressState" class="fw-bold">State</label>
                <form:input path="billingAddress.state" id="billingAddressState"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressCountry"
                       class="fw-bold">Country</label>
                <form:input path="billingAddress.country"
                            id="billingAddressCountry"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressZipCode" class="fw-bold">Zip
                    Code</label>
                <form:input path="billingAddress.zipCode"
                            id="billingAddressZipCode"
                            class="form-Control"/>
            </div>

            <h3>Shipping Address</h3>

            <div class="mb-3">
                <label for="shippingAddressStreetName" class="fw-bold">Street
                    Name</label>
                <form:input path="shippingAddress.streetName"
                            id="shippingAddressStreetName"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="shippingAddressApartmentNumber" class="fw-bold">Apartment
                    Number</label>
                <form:input path="shippingAddress.apartmentNumber"
                            id="shippingAddressApartmentNumber"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="shippingAddressCity" class="fw-bold">City</label>
                <form:input path="shippingAddress.city" id="shippingAddressCity"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="shippingAddressState" class="fw-bold">State</label>
                <form:input path="shippingAddress.state"
                            id="shippingAddressState"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="shippingAddressCountry"
                       class="fw-bold">Country</label>
                <form:input path="shippingAddress.country"
                            id="shippingAddressCountry"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="shippingAddressZipCode" class="fw-bold">Zip
                    Code</label>
                <form:input path="shippingAddress.zipCode"
                            id="shippingAddressZipCode"
                            class="form-Control"/>
            </div>

            <br><br>
            <input type="submit" value="Submit" class="btn btn-primary">
            <a href="<c:url value="/"/>"
               class="btn btn-secondary">Cancel</a>
        </form:form>

    </div>
<%@include file="template/footer.jsp" %>