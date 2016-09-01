<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:main title="Admin List">
    <div class="col-md-6 col-md-offset-3">
        <div class="row text-center">
            <h1>
                <spring:message code="admin.list.label" text="Administrator List"/>
            </h1>
        </div>
        <div class="row">
            <button class="btn btn-default pull-right">
                <spring:message code="admin.list.addAdmin" text="Add Admin"/>
            </button>
        </div>
        <div class="row">
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                    </tr>
                </thead>

                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</t:main>