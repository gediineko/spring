<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:main title="Admin Dashboard">
    <div>
        <h1 class="text-center">
            <spring:message code="common.adminDash" text="Administrator Dashboard"/>
        </h1>
        <h3 class="text-center">
            <spring:message code="common.loggedInAs" text="Logged-in as "/>
        </h3>
    </div>
    <br><br>
    <div class="row">

        <div class="col-md-4 col-md-offset-2">
            <a href="/user/role" class="btn btn-primary btn-block main-links">
                <i class="fa fa-5x fa-briefcase"></i>
                <br>
                <p class="h2">
                    <spring:message code="common.roleManagement" text="Role Management"/>
                </p>
            </a>
        </div>

        <div class="col-md-4">
            <a href="/user" class="btn btn-primary btn-block main-links">
                <i class="fa fa-5x fa-user"></i>
                <br>
                <p class="h2">
                    <spring:message code="common.personManagement" text="Person Management"/>
                </p>
            </a>
        </div>
    </div>

    <!--
    UPLOAD

    <a href="/template/template.csv" download>Download template</a>
    <form action="/admin" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file" class="form-control">
    <button type="submit">Submit</button>
    </form> -->
</t:main>