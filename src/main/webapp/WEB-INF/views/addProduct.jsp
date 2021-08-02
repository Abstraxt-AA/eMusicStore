<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="template/header.jsp" %>

<main>

    <div class="container">
        <div class="accordion-header pt-xxl-4">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product.</p>
        </div>

        <form:form
                action="${pageContext.request.contextPath}/admin/product/addProduct"
                method="post" commandName="product" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="name" class="fw-bold">Name</label>
                <form:errors path="productName" cssStyle="color: #ff0000;"/>
                <form:input path="productName" id="name" class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="category" class="fw-bold">Category</label>
                <label class="form-check-inline">
                    <form:radiobutton path="productCategory" id="category"
                                      value="instrument"/> Instrument
                </label>
                <label class="form-check-inline">
                    <form:radiobutton path="productCategory" id="category"
                                      value="record"/> Record
                </label>
                <label class="form-check-inline">
                    <form:radiobutton path="productCategory" id="category"
                                      value="accessory"/> Accessory
                </label>
            </div>
            <div class="mb-3">
                <label for="description" class="fw-bold">Description</label>
                <form:textarea path="productDescription" id="description"
                               class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="price" class="fw-bold">Price</label>
                <form:errors path="productPrice" cssStyle="color: #ff0000;"/>
                <form:input path="productPrice" id="price"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="condition" class="fw-bold">Condition</label>
                <label class="form-check-inline">
                    <form:radiobutton path="productCondition" id="condition"
                                      value="new"/> New
                </label>
                <label class="form-check-inline">
                    <form:radiobutton path="productCondition" id="condition"
                                      value="used"/> Used
                </label>
            </div>
            <div class="mb-3">
                <label for="status" class="fw-bold">Status</label>
                <label class="form-check-inline">
                    <form:radiobutton path="productStatus" id="status"
                                      value="active"/> Active
                </label>
                <label class="form-check-inline">
                    <form:radiobutton path="productStatus" id="status"
                                      value="inactive"/> Inactive
                </label>
            </div>
            <div class="mb-3">
                <label for="unitsInStock" class="fw-bold">Units In Stock</label>
                <form:errors path="unitsInStock" cssStyle="color: #ff0000;"/>
                <form:input path="unitsInStock" id="unitsInStock"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label for="manufacturer" class="fw-bold">Manufacturer</label>
                <form:input path="productManufacturer" id="manufacturer"
                            class="form-Control"/>
            </div>
            <div class="mb-3">
                <label class="form-control-lg" for="productImage">Upload Picture</label>
                <form:input path="productImage" id="productImage" type="file" class="form:input-lg"/>
            </div>
            <br><br>
            <input type="submit" value="Submit" class="btn btn-primary">
            <a href="<c:url value="/admin/productInventory"/>"
               class="btn btn-secondary">Cancel</a>
        </form:form>

    </div>
<%@include file="template/footer.jsp" %>