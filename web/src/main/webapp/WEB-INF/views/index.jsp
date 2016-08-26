<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Log-In/Sign-up">

    <form class="form" method="post">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="text-center">Log In</h1>
            <br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="">
                <label for="username">UserName</label>
                <input class="form-control" id="username" name="username" placeholder="Username"/>
            </div>
            <br>
            <div>
                <label for="password">Password</label>
                <input class="form-control" id="password" name="password" placeholder="Password"/>
            </div>
            <br>
            <div>
                <button class="btn btn-primary pull-right" type="submit">Submit</button>
            </div>
        </div>
    </form>

</t:main>