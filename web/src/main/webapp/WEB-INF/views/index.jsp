<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <c:redirect url="/login/success"/>
</sec:authorize>

<t:main title="Log In">
    <form class="form" method="post">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="text-center"><spring:message code="common.logIn" text="Log-In"/></h1>
            <br>
            <div class="">
                <label for="username"><spring:message code="common.userName" text="Username"/></label>
                <input class="form-control" id="username" name="username" placeholder="Username"/>
            </div>
            <br>
            <div>
                <label for="password"><spring:message code="common.password" text="Password"/></label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password"/>
            </div>
            <br>
            <div>
                <button class="btn btn-primary pull-right" type="submit" method="post">
                    <spring:message code="common.submit" text="Submit"/>
                </button>
            </div>
        </div>
    </form>

</t:main>