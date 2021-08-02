<%@ include file="template/header.jsp" %>

<div class="container">
    <div class="container">
        <div id="login-box" class="pt-xxl-4">

            <h2>Login with Username and Password</h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="error" style="color: #ff0000">${error}</div>
            </c:if>

            <form name="loginForm"
                  action="<c:url value="/j_spring_security_check"/>"
                  method="post">
                <div class="form-label">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username"
                           class="form-control">
                </div>
                <div class="form-label">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password"
                           class="form-control">
                </div>

                <input type="submit" value="Submit" class="btn btn-primary">

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </form>

        </div>
    </div>
</div>

<%@include file="template/footer.jsp" %>