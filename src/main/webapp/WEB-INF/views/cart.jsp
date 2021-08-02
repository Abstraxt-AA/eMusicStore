<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="template/header.jsp" %>

<div class="container">
    <section>
        <div class="jumbotron pt-xxl-4">
            <div class="container">
                <h1>Cart</h1>

                <p>All the selected products in your shopping cart</p>
            </div>
        </div>
    </section>

    <section class="container" ng-app="cartApp">
        <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
            <div class="float-end">
                <a href="#" class="btn btn-danger"
                   ng-click="clearCart()"><span
                        class="bi bi-x-octagon-fill pe-1"></span>Clear Cart</a>
                <a href="<spring:url value="/order/${cartId}"/>"
                   class="btn btn-warning"><span
                        class="bi bi-cart-check-fill pe-1"></span>Checkout</a>
            </div>

            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <tr ng-repeat="item in cart.cartItems">
                    <td>{{item.product.productName}}</td>
                    <td>{{item.product.productPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger"
                           ng-click="removeFromCart(item.product.productId)">
                        <span class="bi bi-x-octagon-fill pe-1"></span>remove
                    </a>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>{{calGrandTotal()}}</th>
                    <th></th>
                </tr>
            </table>

            <a href="<spring:url value="/product/productList"/>"
               class="btn btn-primary">Continue Shopping</a>
        </div>
    </section>
</div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="template/footer.jsp" %>