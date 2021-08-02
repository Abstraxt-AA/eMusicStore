<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<main>

  <div class="container">
    <div class="accordion-header pt-xxl-4">
      <h1>Customer</h1>

      <p class="lead">Customer Details</p>
    </div>

    <form:form commandName="order" class="form-horizontal">

      <h3>Shipping Address</h3>

      <div class="mb-3">
        <label for="shippingAddressStreetName" class="fw-bold">Street Name</label>
        <form:input path="cart.customer.shippingAddress.streetName" id="shippingAddressStreetName"
                    class="form-Control"/>
      </div>
      <div class="mb-3">
        <label for="shippingAddressApartmentNumber" class="fw-bold">Apartment
          Number</label>
        <form:input path="cart.customer.shippingAddress.apartmentNumber"
                    id="shippingAddressApartmentNumber"
                    class="form-Control"/>
      </div>
      <div class="mb-3">
        <label for="shippingAddressCity" class="fw-bold">City</label>
        <form:input path="cart.customer.shippingAddress.city" id="shippingAddressCity"
                    class="form-Control"/>
      </div>
      <div class="mb-3">
        <label for="shippingAddressState" class="fw-bold">State</label>
        <form:input path="cart.customer.shippingAddress.state" id="shippingAddressState"
                    class="form-Control"/>
      </div>
      <div class="mb-3">
        <label for="shippingAddressCountry" class="fw-bold">Country</label>
        <form:input path="cart.customer.shippingAddress.country" id="shippingAddressCountry"
                    class="form-Control"/>
      </div>
      <div class="mb-3">
        <label for="shippingAddressZipCode" class="fw-bold">Zip Code</label>
        <form:input path="cart.customer.shippingAddress.zipCode" id="shippingAddressZipCode"
                    class="form-Control"/>
      </div>

      <input type="hidden" name="flowExecutionKey"/>

      <br><br>
      <button class="btn btn-warning" name="_eventId_backToCollectCustomerInfo">Back</button>
      <input type="submit" value="Next" class="btn btn-primary" name="_eventId_shippingDetailCollected"/>
      <button class="btn btn-secondary" name="_eventId_cancel">Cancel</button>
    </form:form>

  </div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>