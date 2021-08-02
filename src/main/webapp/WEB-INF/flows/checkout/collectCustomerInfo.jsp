<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<main>

    <div class="container">
        <div class="accordion-header pt-xxl-4">
            <h1>Customer</h1>

            <p class="lead">Customer Details</p>
        </div>

        <form:form commandName="order" class="form-horizontal">
            <h3>Basic Info</h3>

            <div class="mb-3">
                <label for="name" class="fw-bold">Name</label>
                <form:input path="cart.customer.customerName" id="name" class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="email" class="fw-bold">Email</label>
                <form:input path="cart.customer.customerEmail" id="email"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="phone" class="fw-bold">Phone</label>
                <form:input path="cart.customer.customerPhone" id="phone"
                            class="form-Control"/>
            </div>

            <h3>Billing Address</h3>

            <div class="mb-3">
                <label for="billingAddressStreetName" class="fw-bold">Street Name</label>
                <form:input path="cart.customer.billingAddress.streetName" id="billingAddressStreetName"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressApartmentNumber" class="fw-bold">Apartment
                    Number</label>
                <form:input path="cart.customer.billingAddress.apartmentNumber"
                            id="billingAddressApartmentNumber"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressCity" class="fw-bold">City</label>
                <form:input path="cart.customer.billingAddress.city" id="billingAddressCity"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressState" class="fw-bold">State</label>
                <form:input path="cart.customer.billingAddress.state" id="billingAddressState"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressCountry" class="fw-bold">Country</label>
                <form:input path="cart.customer.billingAddress.country" id="billingAddressCountry"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="billingAddressZipCode" class="fw-bold">Zip Code</label>
                <form:input path="cart.customer.billingAddress.zipCode" id="billingAddressZipCode"
                            class="form-Control"/>
            </div>

            <input type="hidden" name="flowExecutionKey"/>

            <br><br>
            <input type="submit" value="Next" class="btn btn-primary" name="_eventId_customerInfoCollected"/>
            <button class="btn btn-secondary" name="_eventId_cancel">Cancel</button>
        </form:form>

    </div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>