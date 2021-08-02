<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="template/header.jsp" %>

<main>

  <div class="container">
    <div class="accordion-header pt-xxl-4">
      <h1>Customer Management Page</h1>

      <p class="lead">This is the customer managmeent page.</p>
    </div>

    <table class="table table-striped table-hover">
      <thead>
      <tr class="bg-success">
        <th>Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Username</th>
        <th>Enabled</th>
      </tr>
      </thead>
      <c:forEach items="${customers}" var="customer">
        <tr>
          <td>${customer.customerName}</td>
          <td>${customer.customerEmail}</td>
          <td>${customer.customerPhone}</td>
          <td>${customer.customerUsername}</td>
          <td>${customer.enabled}</td>
        </tr>
      </c:forEach>
    </table>

<%@include file="template/footer.jsp" %>