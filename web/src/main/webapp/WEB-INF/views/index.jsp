<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Log-In/Sign-up">

    <form class="form">
        <div class="col-md-6">
            <label for="username">UserName</label>
            <input class="form-control" id="username" placeholder="Username"/>
            <label for="password">Password</label>
            <input class="form-control" id="password" placeholder="Password"/>
            <button type="submit">Submit</button>
        </div>
    </form>

</t:main>